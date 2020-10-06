package faconta.fabio.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Contato_Adapter (val contatos: List<Contato>,
                         val onClick: (Contato) -> Unit
): RecyclerView.Adapter<Contato_Adapter.DisciplinasViewHolder>() {

    class DisciplinasViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImg: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImg = view.findViewById(R.id.card_img)
            cardProgress = view.findViewById(R.id.card_progressbar)
            cardView = view.findViewById(R.id.card_disciplina)
        }



    }

    override fun getItemCount() = this.contatos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisciplinasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_contato__adapter,parent, false)

        val holder = DisciplinasViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: DisciplinasViewHolder, position: Int) {
        val context = holder.itemView.context
        val contato = this.contatos[position]

        holder.cardNome.text = contato.nome
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(context).load(contato.foto).fit().into(holder.cardImg,
            object : com.squareup.picasso.Callback {
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            })

        holder.itemView.setOnClickListener { onClick(contato) }
    }
    }