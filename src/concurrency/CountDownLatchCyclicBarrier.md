#### CountDownLatch
A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.
#### CyclicBarrier
A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point.
                
#### Difference 1
- One major difference is that CyclicBarrier takes an (optional) Runnable task which is run once the common barrier condition is met.
- It also allows you to get the number of clients waiting at the barrier and the number required to trigger the barrier. Once triggered the barrier is reset and can be used again.
- For simple use cases - services starting etc... a CountdownLatch is fine. 
- A CyclicBarrier is useful for more complex co-ordination tasks. 
- An example of such a thing would be parallel computation - where multiple subtasks are involved in the computation - kind of like MapReduce.

**Difference 2:**
- When using a CyclicBarrier, the assumption is that _**you specify the number of waiting threads that trigger the barrier**_. If you specify 5, you must have at least 5 threads to call await().

- When using a CountDownLatch, **_you specify the number of calls to countDown() that will result in all waiting threads being released_**. This means that you can use a CountDownLatch with only a single thread.

**Difference 3:**
One point that nobody has yet mentioned is that, in a CyclicBarrier, if a thread has a 
problem (timeout, interrupted...), all the others that have reached await() get an exception. See Javadoc:

_"The CyclicBarrier uses an all-or-none breakage model for failed synchronization attempts: 
If a thread leaves a barrier point prematurely because of interruption, failure, or timeout, all other 
threads waiting at that barrier point will also leave abnormally via BrokenBarrierException 
(or InterruptedException if they too were interrupted at about the same time)."_

