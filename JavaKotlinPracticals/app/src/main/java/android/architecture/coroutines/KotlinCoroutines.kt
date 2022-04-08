package android.architecture.coroutines

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// This will execute on main thread
fun main() = runBlocking {

    print("Main Program Starts: ${Thread.currentThread().name}")

    // Create coroutines using launch builder
    val job: Job = launch {
        print("\n\nUsing Launch")
        print("\nBackground Coroutine Starts: ${Thread.currentThread().name}")
        delay(1000)
        print("\nBackground Coroutine Ends: ${Thread.currentThread().name}")
    }

    job.join() // waits for coroutine execution ends

    // Create coroutines using launch builder
    val jobdiffered: Deferred<String> = async {
        print("\n\nUsing Async")
        print("\nBackground Coroutine Starts: ${Thread.currentThread().name}")
        delay(1000)
        print("\nBackground Coroutine Ends: ${Thread.currentThread().name}")
        "Async Cororutine"
    }

    val value = jobdiffered.await() // waits for coroutine execution ends
    print("\nData from coroutine: $value")

    print("\nMain Thread Alive or not? : ${Thread.currentThread().isAlive}")
    print("\nMain Program ends: ${Thread.currentThread().name}")

}