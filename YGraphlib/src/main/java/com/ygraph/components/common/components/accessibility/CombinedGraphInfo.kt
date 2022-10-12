package com.ygraph.components.common.components.accessibility

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ygraph.components.common.components.ItemDivider
import com.ygraph.components.common.model.Point
import com.ygraph.components.graph.bargraph.models.GroupBar

@Composable
fun CombinedGraphInfo(
    pointsList: List<Point>,
    lineColor: List<Color>,
    groupBar: GroupBar?,
    axisLabelDescription: String,
    barColorPaletteList: List<Color>
) {
    // Merge elements below for accessibility purposes
    Row(modifier = Modifier
        .padding(start = 10.dp, end = 10.dp)
        .clickable { }
        .semantics(mergeDescendants = true) {}, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(axisLabelDescription, fontSize = 12.sp)
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(5.dp)
        ) {
            pointsList.forEachIndexed { index, point ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .background(
                                color = lineColor[index],
                                shape = RoundedCornerShape(corner = CornerSize(10.dp))
                            )
                            .size(10.dp)
                    )
                    Text(point.description, fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.height(5.dp))
            }
            ItemDivider(thickness = 1.dp)
            groupBar?.barList?.forEachIndexed { index, value ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .background(barColorPaletteList[index])
                            .size(20.dp)
                    )
                    Text(value.description, fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}
