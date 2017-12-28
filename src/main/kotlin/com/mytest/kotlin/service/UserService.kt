package com.mytest.kotlin.service

import com.mytest.kotlin.dao.UserDao
import com.mytest.kotlin.domain.User
import com.mytest.kotlin.jpa.UserRepository
import org.hibernate.SQLQuery
import org.hibernate.transform.Transformers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Service
class UserService : UserDao {
    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var sendService: SendService
    @PersistenceContext
    private val em: EntityManager? = null

    fun getEm() = em!!

    /**
     * jpql方式等同于
     * @query("select u from User u where u.name = :name order by u.id desc")
     * fun getUserListByName(): MutableList<Any?>?
     */
    fun getUserListByName(name: String): MutableList<User> {
        var sql = "select u from User u where u.name = :name order by u.id desc"
        val query = getEm().createQuery(sql)
        query.setParameter("name", name)
        return query?.resultList as MutableList<User>
    }

    /**
     * 源生sql方式
     */
    fun getAlluserListByName(name: String): MutableList<User> {
        var sql = "select id,name from t_user as u where u.name = ? order by u.id desc limit 10"
        var query = getEm().createNativeQuery(sql).setParameter(1, name)
        query.unwrap(SQLQuery::class.java).setResultTransformer(Transformers.aliasToBean(User::class.java))
        return query.resultList as MutableList<User>
    }

    override fun addUser(user: User) = userRepository.save(user)


    override fun getUserById(id: Int) = userRepository.findOne(id)

    override fun getListByName(name: String): MutableList<User> = userRepository.getUserList(name)

    fun sendMsg(msg: String) {
        sendService.sendMsg(msg)
    }
}