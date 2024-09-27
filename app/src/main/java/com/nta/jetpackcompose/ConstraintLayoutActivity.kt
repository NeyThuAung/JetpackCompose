package com.nta.jetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

class ConstraintLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val constraints = ConstraintSet {

                val greenbox = createRefFor("greenbox")
                val redbox = createRefFor("redbox")
                //val guideline = createGuidelineFromTop(0.5f) set in op.linkTo(parent.top)

                constrain(greenbox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                constrain(redbox) {
                    top.linkTo(parent.top)
                    start.linkTo(greenbox.end)
                    end.linkTo(parent.end)
                    width = Dimension.value(100.dp)
//                    width = Dimension.fillToConstraints
                    height = Dimension.value(100.dp)
                }

                createHorizontalChain(greenbox, redbox, chainStyle = ChainStyle.Spread)

            }

            ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {

                Box(
                    modifier = Modifier
                        .background(Color.Green)
                        .layoutId("greenbox")
                )

                Box(
                    modifier = Modifier
                        .background(Color.Red)
                        .layoutId("redbox")
                )

            }


        }

    }
}