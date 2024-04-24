package ac.bracu.abdullaharif.bracnav

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MapActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        // Declaring and initializing
        // the elements from the layout file
        val mImageView = findViewById<ImageView>(R.id.imageView)
        val mButton = findViewById<Button>(R.id.btnNext)

        // Create a Bitmap of 500 x 700 size
        val mBitmap = Bitmap.createBitmap(800, 1000, Bitmap.Config.ARGB_8888)

        // Create a canvas with gray background
        // and set it in ImageView
        val mCanvas = Canvas(mBitmap)
        mImageView.setImageBitmap(mBitmap)

        // On Button click
        mButton.setOnClickListener {

            // Paint is called, assume it as a paint bristle
            // with green paint and 10 as thickness
            val mPaint = Paint()
            mPaint.color = Color.RED
            mPaint.style = Paint.Style.STROKE
            mPaint.strokeWidth = 5F
            mPaint.isAntiAlias = true

            // 12F-31L to 12H-33L

            // Declaring start and end
            // coordinates on the canvas
            // 1

            val mStartX = 190F
            val mStartY = 425F
            val mStopX = 190F
            val mStopY = 365F

            // Draw the line
            mCanvas.drawLine(mStartX, mStartY, mStopX, mStopY, mPaint)

            // Declaring start and end
            // coordinates on the canvas
            // 2

            val mStartX2 = 190F
            val mStartY2 = 365F
            val mStopX2 = 105F
            val mStopY2 = 365F

            // Draw the line
            mCanvas.drawLine(mStartX2, mStartY2, mStopX2, mStopY2, mPaint)

            // Declaring start and end
            // coordinates on the canvas
            // 3

            val mStartX3 = 105F
            val mStartY3 = 365F
            val mStopX3 = 105F
            val mStopY3 = 205F

            // Draw the line
            mCanvas.drawLine(mStartX3, mStartY3, mStopX3, mStopY3, mPaint)

            // Set this bitmap in the ImageView
            mImageView.setImageBitmap(mBitmap)


        }
    }

}