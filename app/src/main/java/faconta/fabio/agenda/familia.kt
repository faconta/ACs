package faconta.fabio.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.toolbar.*

class familia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_familia)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setSupportActionBar(toolbar_home)
        supportActionBar?.title = "Familia"

    }
}