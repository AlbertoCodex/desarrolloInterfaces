package ies.politecnico.examencompose.Data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Pair(
    @DrawableRes val imagen:Int,
    @StringRes val texto:Int
) {

}