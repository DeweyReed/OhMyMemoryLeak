package xyz.aprildown.ohmymemoryleak

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var isFirst = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.layout, MainActivityFragment())
                .commit()
        }

        fab.setOnClickListener {
            if (isFirst) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.layout, MainActivityFragment2())
                    .addToBackStack(null)
                    .commit()
            } else {
                supportFragmentManager.popBackStack()
            }
            isFirst = !isFirst
        }
    }
}
