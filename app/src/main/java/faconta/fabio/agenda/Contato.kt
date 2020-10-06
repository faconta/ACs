package faconta.fabio.agenda

import java.io.Serializable

class Contato: Serializable {

    var id: Long = 0
    var nome = ""
    var tel = ""
    var foto = ""
    var email = ""

    override fun toString(): String {
        return "Contato(nome=$nome)"
    }

}