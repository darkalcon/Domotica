package domoticHome.example.domotica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.example.domotica.R

class MainActivity : AppCompatActivity()  {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var text_error : TextView = findViewById<TextView>(R.id.text_Error)

        text_error.visibility =View.INVISIBLE


        if(!Python.isStarted())
            Python.start(AndroidPlatform(this))



    }
    fun llamarScriptPython(numPuerta: String): String {
        var text_error : TextView = findViewById<TextView>(R.id.text_Error)
        text_error.visibility =View.GONE



            var py = Python.getInstance()

            var pyPro = py.getModule("cliente_Socket")
        return try {
            var objector = pyPro.callAttr("main", numPuerta)

            var retor = (objector.toString()).split("'");
            retor[1]
        } catch (e: Exception) {
            text_error.visibility =View.VISIBLE
            "0"
        }

    }
    fun verificarEstado(estadoArray: String){

        var estado= estadoArray.split("-")
        for(x in estado  )
        {
            var port = x.split("/")
            when(port[0])
            {
                "0"->{

                }

            }
        }
    }


    fun onClick(v: View) {

        var reborn :String
        try {


            when (v.id) {

                R.id.btn_01 -> {

                    reborn = llamarScriptPython("1")

                    Toast.makeText(this@MainActivity, reborn, Toast.LENGTH_LONG).show()
                }
                R.id.btn_02 -> {
                    reborn = llamarScriptPython("2")
                    Toast.makeText(this@MainActivity, reborn, Toast.LENGTH_LONG).show()
                }
                R.id.btn_03 -> {
                    reborn = llamarScriptPython("3")
                    Toast.makeText(this@MainActivity, reborn, Toast.LENGTH_LONG).show()
                }
                R.id.btn_04 -> {
                    reborn = llamarScriptPython("3")
                    Toast.makeText(this@MainActivity, reborn, Toast.LENGTH_LONG).show()
                }
            }
        }
        catch (e: Exception)
        {

        }

        ///
/*


            R.id.btn_01 ->Toast.makeText(this@MainActivity,"btn 01",Toast.LENGTH_LONG).show()

            R.id.btn_02 -> Toast.makeText(this@MainActivity,"btn 02",Toast.LENGTH_LONG).show()

            R.id.btn_03 -> Toast.makeText(this@MainActivity,"btn 03",Toast.LENGTH_LONG).show()

*/


    }

    private fun abrirPuerta(numPuerta: Int)
    {

        when(numPuerta)
        {
            //codigo del soqued para la coneccion
            1->   {

            }







/*
                val client = Socket("192.168.12.54", 21100)
                //val client = Socket("192.168.12.54", 21100)



                client.outputStream.write("Hello from the client!".toByteArray())

              //  val tex = BufferedReader(InputStreamReader(client.inputStream)).readLine()

                client.close()

                //Toast.makeText(this@MainActivity,tex.toString(),Toast.LENGTH_LONG).show()
                Toast.makeText(this@MainActivity,"lo logro",Toast.LENGTH_LONG).show()
            }

            else->
                Toast.makeText(this@MainActivity,"btn 02",Toast.LENGTH_LONG).show()
*/


        }
    }



}