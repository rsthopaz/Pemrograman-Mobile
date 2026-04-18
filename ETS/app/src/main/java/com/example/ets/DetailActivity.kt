package com.example.ets

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val img = findViewById<ImageView>(R.id.imgDetail)

        findViewById<TextView>(R.id.txtTitle).text = intent.getStringExtra("title")
        findViewById<TextView>(R.id.txtDate).text = intent.getStringExtra("date")
        findViewById<TextView>(R.id.txtGenre).text = intent.getStringExtra("genre")
        findViewById<TextView>(R.id.txtRating).text = intent.getStringExtra("rating")
        findViewById<TextView>(R.id.txtSynopsis).text = intent.getStringExtra("synopsis")

        Glide.with(this)
            .load(intent.getStringExtra("image"))
            .into(img)
    }
}