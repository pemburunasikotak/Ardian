package ardian.belajarbahasainggris


import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_detail_vidio_materi.tvJudulVidio
import kotlinx.android.synthetic.main.activity_detail_vidio_materi.tv_materi
import kotlinx.android.synthetic.main.activity_detail_vidio_materi.youtubePlayer

class DetailVidioMateri:YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_vidio_materi)
        val bundle = intent.extras
        tvJudulVidio.setText((bundle?.getString("nama")))
        tv_materi.setText((bundle?.getString("materi")))

//        val link = bundle?.getString("link")

        youtubePlayer.initialize("AIzaSyDv-gjtmZh1h9WKwQbp-aySccEFlDkxFuk", this)
    }

    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider?,
        player: YouTubePlayer?,
        wasRestored: Boolean
    ) {
        val bundle = intent.extras
        val link = bundle?.getString("link")
        Toast.makeText(this, "Youtube API Initialization Success", Toast.LENGTH_SHORT).show()

        if (!wasRestored) {
            player?.loadVideo(link)
        }
    }

    override fun onInitializationFailure(
        provider: YouTubePlayer.Provider?,
        result: YouTubeInitializationResult?
    ) {
        Toast.makeText(this, "YouTube API Initialization Failure", Toast.LENGTH_SHORT).show()
    }
}