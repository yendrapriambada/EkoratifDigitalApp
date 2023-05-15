package academy.bangkit.interactivemoduleproject

import academy.bangkit.interactivemoduleproject.databinding.ActivityFifteenBinding
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class FifteenActivity : YouTubeBaseActivity() {
    private lateinit var binding: ActivityFifteenBinding
    val VIDEO_ID = "-Brma3I5vso"
    val YOUTUBE_API = "AIzaSyDMby7ViahV_22dXer1uO9pg9fIFJcA1s4"

    private lateinit var youtubePlayer: YouTubePlayerView

    lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifteenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            Intent(this, SixteenActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

        youtubePlayer = findViewById(R.id.youtubePlayer)

        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1?.loadVideo(VIDEO_ID)
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
            }

        }

        youtubePlayer.initialize(YOUTUBE_API, youtubePlayerInit)
    }
}