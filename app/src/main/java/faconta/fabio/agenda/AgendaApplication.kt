package faconta.fabio.agenda

import android.app.Application
import java.lang.IllegalStateException

class AgendaApplication: Application() {

    override fun onCreate(){
        super.onCreate()
        appInstance =this
    }

    companion object{
        private var appInstance: AgendaApplication? = null
        fun getInstance(): AgendaApplication{
            if (appInstance == null){
                throw IllegalStateException("Configurar Application no Manifest")
            }
            return appInstance!!
        }
    }

}