import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.geek_07_21.Eiken_Mode
import com.example.geek_07_21.R



class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.eiken_button)
        button.setOnClickListener {
            // FragmentManagerの取得
            val pfm = parentFragmentManager

            // トランザクションの生成・コミット
            val ft = pfm.beginTransaction()
            ft.apply {
                replace(R.id.fragment_container, Eiken_Mode())
                commit()
            }
        }
    }
}