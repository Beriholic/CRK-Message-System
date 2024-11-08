package xyz.beriholic.kotlinwebspring.model.entity

import org.babyfish.jimmer.sql.Column
import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.Id
import org.babyfish.jimmer.sql.Table
import java.time.LocalDate


/**
 * <p>
 *  tb_comment

 * </p>
 *
 * @author w2h34d
 * @date 2024-11-08
 */
@Entity
@Table(name = "tb_comment")
public interface Comment {

    /**
     *  id

     */
    @Id
    val id: Long

    /**
     *  uid

     */
    val uid: Long

    /**
     *  content

     */
    val content: String

    val username: String

    /**
     *  created_at

     */
    @Column(name = "created_at")
    val createdAt: LocalDate?

}
