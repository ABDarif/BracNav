package ac.bracu.abdullaharif.bracnav

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

class MapActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val mImageView = findViewById<ImageView>(R.id.imageView)
        val mButton = findViewById<Button>(R.id.btnNext)

        // Create a Bitmap of 800 x 1000 size
        val mBitmap = Bitmap.createBitmap(800, 1000, Bitmap.Config.ARGB_8888)

        // Create a canvas with a transparent background
        val mCanvas = Canvas(mBitmap)
        mImageView.setImageBitmap(mBitmap)

        val startX = 190F
        val startY = 425F
        val endX = 190F
        val endY = 365F

        mButton.setOnClickListener {
            // Show dialog to input points dynamically
            //showInputDialog { startX, startY, endX, endY ->
                val mPaint = Paint().apply {
                    color = Color.RED
                    style = Paint.Style.STROKE
                    strokeWidth = 5F
                    isAntiAlias = true
                }

                // Draw the arrow dynamically
                drawArrow(mCanvas, startX, startY, endX, endY, mPaint, tipSize = 20F)

                // Update the ImageView with the new canvas
                mImageView.setImageBitmap(mBitmap)
            //}
        }
    }

    // Method to dynamically draw an arrow
    private fun drawArrow(
        canvas: Canvas,
        startX: Float,
        startY: Float,
        endX: Float,
        endY: Float,
        paint: Paint,
        tipSize: Float
    ) {
        // Draw the main line
        canvas.drawLine(startX, startY, endX, endY, paint)

        // Calculate the angle of the line
        val angle = atan2((endY - startY).toDouble(), (endX - startX).toDouble()).toFloat()

        // Define the arrow tip angles
        val arrowAngle1 = angle + Math.PI.toFloat() / 6
        val arrowAngle2 = angle - Math.PI.toFloat() / 6

        // Calculate the arrow tip points
        val tipX1 = endX - cos(arrowAngle1) * tipSize
        val tipY1 = endY - sin(arrowAngle1) * tipSize
        val tipX2 = endX - cos(arrowAngle2) * tipSize
        val tipY2 = endY - sin(arrowAngle2) * tipSize

        // Draw the arrow tips
        canvas.drawLine(endX, endY, tipX1.toFloat(), tipY1.toFloat(), paint)
        canvas.drawLine(endX, endY, tipX2.toFloat(), tipY2.toFloat(), paint)
    }

//    // Method to show input dialog for points
//    private fun showInputDialog(callback: (Float, Float, Float, Float) -> Unit) {
//        val dialogView = layoutInflater.inflate(R.layout.dialog_points_input, null)
//        val startXInput = dialogView.findViewById<EditText>(R.id.startXInput)
//        val startYInput = dialogView.findViewById<EditText>(R.id.startYInput)
//        val endXInput = dialogView.findViewById<EditText>(R.id.endXInput)
//        val endYInput = dialogView.findViewById<EditText>(R.id.endYInput)
//
//        AlertDialog.Builder(this)
//            .setTitle("Enter Points")
//            .setView(dialogView)
//            .setPositiveButton("Draw") { _, _ ->
//                val startX = startXInput.text.toString().toFloatOrNull() ?: 0F
//                val startY = startYInput.text.toString().toFloatOrNull() ?: 0F
//                val endX = endXInput.text.toString().toFloatOrNull() ?: 0F
//                val endY = endYInput.text.toString().toFloatOrNull() ?: 0F
//                callback(startX, startY, endX, endY)
//            }
//            .setNegativeButton("Cancel", null)
//            .show()

//        mButton.setOnClickListener {
//            val mPaint = Paint().apply {
//                color = Color.RED
//                style = Paint.Style.STROKE
//                strokeWidth = 5F
//                isAntiAlias = true
//            }
//
//            // Draw the lines and add arrows
//
//            // Line 1
//            drawArrow(
//                canvas = mCanvas,
//                startX = 190F,
//                startY = 425F,
//                endX = 190F,
//                endY = 365F,
//                paint = mPaint,
//                tipSize = 20F
//            )
//
//            // Line 2
//            drawArrow(
//                canvas = mCanvas,
//                startX = 190F,
//                startY = 365F,
//                endX = 105F,
//                endY = 365F,
//                paint = mPaint,
//                tipSize = 20F
//            )
//
//            // Line 3
//            drawArrow(
//                canvas = mCanvas,
//                startX = 105F,
//                startY = 365F,
//                endX = 105F,
//                endY = 205F,
//                paint = mPaint,
//                tipSize = 20F
//            )
//
//            // Update the ImageView
//            mImageView.setImageBitmap(mBitmap)
//        }
//    }
//
//    // Draw a line with an arrow tip
//    private fun drawArrow(
//        canvas: Canvas,
//        startX: Float,
//        startY: Float,
//        endX: Float,
//        endY: Float,
//        paint: Paint,
//        tipSize: Float
//    ) {
//        // Draw the main line
//        canvas.drawLine(startX, startY, endX, endY, paint)
//
//        // Calculate the angle of the line
//        val angle = atan2((endY - startY).toDouble(), (endX - startX).toDouble()).toFloat()
//
//        // Define the arrow tip angles
//        val arrowAngle1 = angle + Math.PI.toFloat() / 6
//        val arrowAngle2 = angle - Math.PI.toFloat() / 6
//
//        // Calculate the arrow tip points
//        val tipX1 = endX - cos(arrowAngle1) * tipSize
//        val tipY1 = endY - sin(arrowAngle1) * tipSize
//        val tipX2 = endX - cos(arrowAngle2) * tipSize
//        val tipY2 = endY - sin(arrowAngle2) * tipSize
//
//        // Draw the arrow tips
//        canvas.drawLine(endX, endY, tipX1.toFloat(), tipY1.toFloat(), paint)
//        canvas.drawLine(endX, endY, tipX2.toFloat(), tipY2.toFloat(), paint)

//        // Declaring and initializing
//        // the elements from the layout file
//        val mImageView = findViewById<ImageView>(R.id.imageView)
//        val mButton = findViewById<Button>(R.id.btnNext)
//
//        // Create a Bitmap of 500 x 700 size
//        val mBitmap = Bitmap.createBitmap(800, 1000, Bitmap.Config.ARGB_8888)
//
//        // Create a canvas with gray background
//        // and set it in ImageView
//        val mCanvas = Canvas(mBitmap)
//        mImageView.setImageBitmap(mBitmap)
//
//        // On Button click
//        mButton.setOnClickListener {
//
//            // Paint is called, assume it as a paint bristle
//            // with green paint and 10 as thickness
//            val mPaint = Paint()
//            mPaint.color = Color.RED
//            mPaint.style = Paint.Style.STROKE
//            mPaint.strokeWidth = 5F
//            mPaint.isAntiAlias = true
//
//            // 12F-31L to 12H-33L
//
//            // Declaring start and end
//            // coordinates on the canvas
//            // 1
//
//            val mStartX = 190F
//            val mStartY = 425F
//            val mStopX = 190F
//            val mStopY = 365F
//
//            // Draw the line
//            mCanvas.drawLine(mStartX, mStartY, mStopX, mStopY, mPaint)
//
//            // Declaring start and end
//            // coordinates on the canvas
//            // 2
//
//            val mStartX2 = 190F
//            val mStartY2 = 365F
//            val mStopX2 = 105F
//            val mStopY2 = 365F
//
//            // Draw the line
//            mCanvas.drawLine(mStartX2, mStartY2, mStopX2, mStopY2, mPaint)
//
//            // Declaring start and end
//            // coordinates on the canvas
//            // 3
//
//            val mStartX3 = 105F
//            val mStartY3 = 365F
//            val mStopX3 = 105F
//            val mStopY3 = 205F
//
//            // Draw the line
//            mCanvas.drawLine(mStartX3, mStartY3, mStopX3, mStopY3, mPaint)
//
//            // Set this bitmap in the ImageView
//            mImageView.setImageBitmap(mBitmap)


        //}
    //}

}