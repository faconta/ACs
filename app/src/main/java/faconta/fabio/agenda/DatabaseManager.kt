package faconta.fabio.agenda

import androidx.room.Room

object DatabaseManager {

    private var dbInstance: LMSDataBse

    init{
        val context = AgendaApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            LMSDataBse::class.java,
            "lms.sqlite"
        ).build()
    }

    fun getDisciplinaDAO(): ContatoDAO{
        return dbInstance.contatoDAO()
    }

}