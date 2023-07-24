package info.fekri.composeboom.util

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.fekri.composeboom.R
import info.fekri.composeboom.ui.theme.BackgroundMain
import info.fekri.composeboom.ui.theme.BlueBackground
import info.fekri.composeboom.ui.theme.Shapes
import info.fekri.composeboom.ui.theme.YellowBackground

@Preview("IconMainApp")
@Composable
fun IconMainApp() {
    Card(
        border = BorderStroke(2.dp, Color.White),
        modifier = Modifier.size(140.dp),
        shape = RoundedCornerShape(80.dp),
        elevation = 5.dp,
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_icon_main_no_back),
            contentDescription = null,
            modifier = Modifier.padding(8.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun MyEditText(edtValue: String, icon: ImageVector, hint: String, keyboardType: KeyboardType = KeyboardType.Text, imeAction: ImeAction = ImeAction.Next, onValueChanges: (String) -> Unit) {
    OutlinedTextField(
        label = { Text(hint) },
        value = edtValue,
        singleLine = true,
        onValueChange = onValueChanges,
        placeholder = { Text(hint, color = Color.Gray) },
        modifier = Modifier
            .fillMaxWidth(0.9f),
        shape = Shapes.medium,
        leadingIcon = { Icon(icon, null) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction)
    )
}

@Composable
fun ShowAlertDialog(
    title: String,
    msg: String,
    btnMsg: String,
    onConfirmClicked: () -> Unit,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp) },
        text = { Text(text = msg, fontWeight = FontWeight.Medium, fontSize = 15.sp) },
        confirmButton = {
            TextButton(onClick = onConfirmClicked) {
                Text(text = btnMsg, modifier = Modifier.padding(8.dp), fontSize = 16.sp)
            }
        }
    )
}
