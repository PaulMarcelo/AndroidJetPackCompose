package ec.com.pmyb.todoapp.addtasks.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import ec.com.pmyb.todoapp.R
import ec.com.pmyb.todoapp.addtasks.ui.model.TaskModel
import ec.com.pmyb.todoapp.ui.TasksViewModel


@Composable
fun TasksScreen(tasksViewModel: TasksViewModel) {

    val showDialog: Boolean by tasksViewModel.showDialog.observeAsState(initial = false)

    Box(modifier = Modifier.fillMaxSize()) {
        AddTaskDialog(show = showDialog,
            onDissmiss = { tasksViewModel.onDialogClose() },
            onTaskAdd = { tasksViewModel.onTasksCreated(it) }
        )
        FabDialog(
            Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            tasksViewModel
        )
        TasksList(tasksViewModel)
    }
}

@Composable
fun TasksList(tasksViewModel: TasksViewModel) {
    val myTasks: List<TaskModel> = tasksViewModel.task
    LazyColumn {
        items(myTasks, key = { it.id }) {
            ItemTask(task = it, tasksViewModel = tasksViewModel)
        }
    }
}

@Composable
fun ItemTask(task: TaskModel, tasksViewModel: TasksViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .pointerInput(Unit) {
                detectTapGestures(onLongPress = {
                    tasksViewModel.onItemRemove(task)
                })
            },
        border = BorderStroke(2.dp, Color.Black),
        elevation = 8.dp
    ) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = task.task, modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .weight(1f)
            )
            Checkbox(
                checked = task.selected,
                onCheckedChange = { tasksViewModel.onCheckBoxSelected(task) })
        }
    }
}

@Composable
fun FabDialog(modifier: Modifier, tasksViewModel: TasksViewModel) {
    FloatingActionButton(
        onClick = {
            tasksViewModel.onShowDialogClick()
        },
        modifier = modifier
    ) {
        Icon(Icons.Default.Add, contentDescription = "")
    }
}

@Composable
fun AddTaskDialog(show: Boolean, onDissmiss: () -> Unit, onTaskAdd: (String) -> Unit) {
    val context = LocalContext.current
    var myTask by remember {
        mutableStateOf("")
    }
    if (show) {
        Dialog(onDismissRequest = { onDissmiss() }) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text(
                    text = context.getString(R.string.add_you_tasks), fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black

                )
                Spacer(modifier = Modifier.size(16.dp))
                TextField(
                    value = myTask, onValueChange = { myTask = it },
                    singleLine = true, maxLines = 1
                )
                Spacer(modifier = Modifier.size(16.dp))
                Button(onClick = {
                    onTaskAdd(myTask)
                    myTask = " "
                }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = context.getString(R.string.add_you_tasks))
                }
            }
        }
    }
}