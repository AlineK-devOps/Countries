package ru.cft.shift2021summer.countries.filter.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.ActionBar
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.countries.main.presentation.MainActivity

class FilterActivity : AppCompatActivity(), FilterView {
    private val presenter = FilterPresenter()

    companion object{
        fun start(context: Context){
            val intent = Intent(context, FilterActivity::class.java).apply{}
            context.startActivity(intent)
        }
    }

    private var regions: MutableList<CheckBox> = mutableListOf()
    private var regionalBlocks: MutableList<CheckBox> = mutableListOf()

    private lateinit var showButton: Button
    private var actionBar: ActionBar? = null

    private lateinit var allRegionBox: CheckBox
    private lateinit var americasBox: CheckBox
    private lateinit var asiaBox: CheckBox
    private lateinit var europeBox: CheckBox
    private lateinit var africaBox: CheckBox
    private lateinit var oceaniaBox: CheckBox

    private lateinit var allBlocksBox: CheckBox
    private lateinit var euBox: CheckBox
    private lateinit var eftaBox: CheckBox
    private lateinit var caricomBox: CheckBox
    private lateinit var paBox: CheckBox
    private lateinit var auBox: CheckBox
    private lateinit var usanBox: CheckBox
    private lateinit var eeuBox: CheckBox
    private lateinit var alBox: CheckBox
    private lateinit var caisBox: CheckBox
    private lateinit var aseanBox: CheckBox
    private lateinit var ceftaBox: CheckBox
    private lateinit var naftaBox: CheckBox
    private lateinit var saarcBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        presenter.attachView(this)

        showButton = findViewById(R.id.showButton)
        actionBar = supportActionBar


        allRegionBox = findViewById(R.id.allRegionBox)
        regions.add(allRegionBox)

        americasBox = findViewById(R.id.americasBox)
        regions.add(americasBox)

        asiaBox = findViewById(R.id.asiaBox)
        regions.add(asiaBox)

        europeBox = findViewById(R.id.europeBox)
        regions.add(europeBox)

        africaBox = findViewById(R.id.africaBox)
        regions.add(africaBox)

        oceaniaBox = findViewById(R.id.oceaniaBox)
        regions.add(oceaniaBox)


        allBlocksBox = findViewById(R.id.allBlocksBox)
        regionalBlocks.add(allBlocksBox)

        euBox = findViewById(R.id.euBox)
        regionalBlocks.add(euBox)

        eftaBox = findViewById(R.id.eftaBox)
        regionalBlocks.add(eftaBox)

        caricomBox = findViewById(R.id.caricomBox)
        regionalBlocks.add(caricomBox)

        paBox = findViewById(R.id.paBox)
        regionalBlocks.add(paBox)

        auBox = findViewById(R.id.auBox)
        regionalBlocks.add(auBox)

        usanBox = findViewById(R.id.usanBox)
        regionalBlocks.add(usanBox)

        eeuBox = findViewById(R.id.eeuBox)
        regionalBlocks.add(eeuBox)

        alBox = findViewById(R.id.alBox)
        regionalBlocks.add(alBox)

        caisBox = findViewById(R.id.caisBox)
        regionalBlocks.add(caisBox)

        aseanBox = findViewById(R.id.aseanBox)
        regionalBlocks.add(aseanBox)

        ceftaBox = findViewById(R.id.ceftaBox)
        regionalBlocks.add(ceftaBox)

        naftaBox = findViewById(R.id.naftaBox)
        regionalBlocks.add(naftaBox)

        saarcBox = findViewById(R.id.saarcBox)
        regionalBlocks.add(saarcBox)
    }

    override fun onResume() {
        super.onResume()
        presenter.onScreenResumed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            android.R.id.home -> {
                presenter.onBackButtonClicked()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun bindFilter() {
        actionBar?.title = "Filter"

        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        showButton.setOnClickListener { presenter.onShowButtonClicked() }
    }

    override fun getFilterParams() {
        var params: MutableList<String> = mutableListOf()

        for (checkBox1 in regions){
            if (checkBox1.isChecked)
                params.add("region-" + checkBox1.text)
        }

        for (checkBox2 in regionalBlocks){
            if (checkBox2.isChecked)
                params.add("regionalBlock-" + checkBox2.text)
        }

        MainActivity.start(this, Array(params.size) { params[it] })
    }

    override fun closeScreen() {
        finish()
    }
}