package faconta.fabio.agenda

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "contato")


class Contato: Serializable {

    @PrimaryKey
    var id: Long = 0
    var nome = ""
    var telefone = ""
    var foto = ""
    var email = ""

    override fun toString(): String {
        return "Contato(nome=$nome)"
    }

}