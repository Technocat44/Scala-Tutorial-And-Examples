package lo4_data_structures.graphs

import lo4_data_structures.linkedlist.Queue

object BFS {
/*
how BFS works:
We pick a starting node in the graph.
From there we go to the adjacencyList (which is a map storing the node ID's and a list of all the edges/neighbors of the node)
and we're going to say, ok we are exploring this node, what are all the neighbors of this node?
We take all those edges/neighbors (keep track that we've explored them) look them up in the adjacencyList /map
and then explore all of their neighbors,
Then we take all of those edges/neighbors (keeping track) look them up in the adjacencyList /map and
explore all of their neighbors. and we repeat.
Once we get to the point where no new nodes are being explored, we're done, we have found all the connected edges of the starting node

 */
  def bfs[A](graph: Graph[A], startID: Int): Unit = {

    var explored: Set[Int] = Set(startID) // this is a set(a list that doesn't store duplicates) and we are storing the
    // starting ID. The starting ID is the ID of the node we want to being at.
    var path: Map[Int, Int] = Map()
    path += (startID) -> -1

    val toExplore: Queue[Int] = new Queue() // We create a queue, which is a data structure that is FIFO. elements can only
    // be added to the end. and only the element at the front of the line can be accessed
    // enqueue - adds an elements to the end of the line
    // dequeue - removes an element from the front of the line
    toExplore.enqueue(startID) // we add the first node to the front of the queue

    while (!toExplore.empty()) { // while the queue has an element in it
      val nodeToExplore = toExplore.dequeue() // dequeue returns the element that was being stored in the front of the queue
      for (node <- graph.adjacencyList(nodeToExplore)) { // the adjList stores a map of ID's -> List(connected nodes/ neighbors)
        // so when we code ^^^^ we are checking the map for the key of the node ID, that returns a list of all the connected edges (neighbors) to that node
        if (!explored.contains(node)) { // if the set doesn't contain the ID of the edges that are connected to the node
          println("exploring: " + graph.nodes(node))
          path += node -> nodeToExplore
          toExplore.enqueue(node) // add the connected edge to the queue so we make sure we check all its neighbors
          explored = explored + node // and then add the connected edge node to the Set so we know we have checked its edges
        }
      }
    }
    println("these are all the explored nodes = " +explored)
    println("this is the pathe = " + path)
  }

}
