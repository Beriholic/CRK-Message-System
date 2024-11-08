package xyz.beriholic.kotlinwebspring.model.entity

import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.Id
import org.babyfish.jimmer.sql.Key
import org.babyfish.jimmer.sql.Table


/**
 * <p>
 *  tb_user

 * </p>
 *
 * @author w2h34d
 * @date 2024-10-31
 */
@Entity
@Table(name = "tb_user")
public interface User {

    /**
     *  id

     */
    @Id
    val id: Long

    /**
     *  username

     */
    @Key
    val username: String?

    /**
     *  password

     */
    val password: String
}
