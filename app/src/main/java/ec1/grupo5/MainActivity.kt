package ec1.grupo5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ec1.grupo5.databinding.ActivityMainBinding
import kotlin.math.round
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        CalcularDcto()
    }

    private fun CalcularDcto() {
        var cant = binding.edtCantidad.text.toString().toDouble()
        var prec = binding.edtPrecio.text.toString().toDouble()
        var total = cant * prec
        var resultado = ""
        if (total > 200){
            var desc =  total - 0.2 * total
            val descRound = (desc * 100.00).roundToInt() / 100.0
            resultado = "Precio (aplicado 20% descuento): $$descRound"
        }else{
            var totalRound = (total * 100.00).roundToInt() / 100.0
            resultado = "Precio Total: $$totalRound"
        }

        binding.tvResultado.text = resultado
    }
}