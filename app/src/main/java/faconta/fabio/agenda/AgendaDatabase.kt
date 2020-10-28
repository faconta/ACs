package faconta.fabio.agenda

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Contato::class), version = 1)
abstract class LMSDataBse: RoomDatabase() {
    abstract fun contatoDAO(): ContatoDAO

}