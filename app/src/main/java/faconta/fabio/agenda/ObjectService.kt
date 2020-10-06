package faconta.fabio.agenda

import android.content.Context

object ObejctService {


    fun getContatos(Context: Context): List<Contato>{
        val contatos = mutableListOf<Contato>()

        for(i in 1..10){
            val c = Contato()
            c.nome = "Contato $i"
            c.tel = "Contato $i"
            c.email = "Contato $i"
            c.foto = "https://i0.wp.com/mestredati.com/wp-content/uploads/2019/11/android-logo.png"
            contatos.add(c)
        }
        return contatos
    }
}