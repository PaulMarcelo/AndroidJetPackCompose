package ec.com.pmyb.jetpackcomponentscatalog.ui

data class CheckInfo(
    val title: String,
    var seleted: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)
