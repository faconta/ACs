package faconta.fabio.agenda

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object ObejctService {
    val host = "https://fesousa.pythonanywhere.com"
    val TAG = "WS_LMSApp"

    fun getContatos(Context: Context): List<Contato>{
        val contatos = mutableListOf<Contato>()

        for(i in 1..10){
            val c = Contato()
            c.nome = "Contato $i"
            c.telefone = "Contato $i"
            c.email = "Contato $i"
            c.foto = "https://i0.wp.com/mestredati.com/wp-content/uploads/2019/11/android-logo.png"
            contatos.add(c)
        }
        return contatos
    }

    inline fun <reified T>parserJson(json: String): T{
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }

    fun saveDisciplina(disciplina: Contato) {
        val dao = DatabaseManager.getDisciplinaDAO()
        dao.insert(disciplina)


        val url = "$host/contatos"
        val jsonDisciplina = GsonBuilder().create().toJson(disciplina)
        HttpHelper.post(url, jsonDisciplina)
    }
}