package faconta.fabio.agenda

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.nio.channels.SelectableChannel

@Dao
interface ContatoDAO {
    @Query("Select * from contato where id = :id")
    fun getById(id:Long): Contato?
    @Query("Select * from contato")
    fun getAll(): List<Contato>
    @Insert
    fun insert(disciplina: Contato)
    @Delete
    fun delete(disciplina: Contato)
}