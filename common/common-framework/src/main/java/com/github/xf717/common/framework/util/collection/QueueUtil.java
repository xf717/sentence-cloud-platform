package com.github.xf717.common.framework.util.collection;

import com.google.common.collect.EvictingQueue;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Queue工具集.
 * <p>
 * 1.各种Queue，Dequeue的创建
 * <p>
 * 2.特殊类型Queue:LIFO的Stack, LRU的Queue
 *
 * @author 队列工具
 */
public final class QueueUtil {

  private QueueUtil() {
    throw new AssertionError("Must not instantiate utility class");
  }

  /**
   * 创建ArrayDeque (JDK无ArrayQueue)
   * <p>
   * 需设置初始长度，默认为16，数组满时成倍扩容
   */
  public static <E> ArrayDeque<E> newArrayDeque(int initSize) {
    return new ArrayDeque<E>(initSize);
  }

  /**
   * 创建LinkedDeque (LinkedList实现了Deque接口)
   */
  public static <E> LinkedList<E> newLinkedDeque() {
    return new LinkedList<E>();
  }

  /**
   * 创建无阻塞情况下，性能最优的并发队列
   */
  public static <E> ConcurrentLinkedQueue<E> newConcurrentNonBlockingQueue() {
    return new ConcurrentLinkedQueue<E>();
  }

  /**
   * 创建无阻塞情况下，性能最优的并发双端队列
   */
  public static <E> Deque<E> newConcurrentNonBlockingDeque() {
    return new java.util.concurrent.ConcurrentLinkedDeque<E>();
  }

  /**
   * 创建并发阻塞情况下，长度不受限的队列.
   * <p>
   * 长度不受限，即队列不会因为满而阻塞，但会因为空而阻塞.
   */
  public static <E> LinkedBlockingQueue<E> newBlockingUnlimitQueue() {
    return new LinkedBlockingQueue<E>();
  }

  /**
   * 创建并发阻塞情况下，长度不受限的双端队列.
   * <p>
   * 长度不受限，即队列不会因为满而阻塞，但会因为空而阻塞.
   */
  public static <E> LinkedBlockingDeque<E> newBlockingUnlimitDeque() {
    return new LinkedBlockingDeque<E>();
  }

  /**
   * 创建并发阻塞情况下，长度受限，更节约内存，但共用一把锁的队列（无双端队列实现）.
   */
  public static <E> ArrayBlockingQueue<E> newArrayBlockingQueue(int capacity) {
    return new ArrayBlockingQueue<E>(capacity);
  }

  /**
   * 创建并发阻塞情况下，长度受限，头队尾两把锁, 但使用更多内存的队列.
   */
  public static <E> LinkedBlockingQueue<E> newLinkedBlockingQeque(int capacity) {
    return new LinkedBlockingQueue<E>(capacity);
  }

  /**
   * 创建并发阻塞情况下，长度受限，头队尾两把锁, 但使用更多内存的双端队列.
   */
  public static <E> LinkedBlockingDeque<E> newBlockingDeque(int capacity) {
    return new LinkedBlockingDeque<E>(capacity);
  }

  //////////////// 特殊类型Queue：Stack ///////////

  /**
   * 支持后进先出的栈，用ArrayDeque实现, 经过Collections#asLifoQueue()转换顺序
   * <p>
   * 需设置初始长度，默认为16，数组满时成倍扩容
   *
   * @see Collections#asLifoQueue()
   */
  public static <E> Queue<E> createStack(int initSize) {
    return Collections.asLifoQueue(new ArrayDeque<E>(initSize));
  }

  /**
   * 支持后进先出的并发栈，用ConcurrentLinkedDeque实现，经过Collections#asLifoQueue()转换顺序
   * <p>
   * 另对于BlockingQueue接口， JDK暂无Lifo倒转实现，因此只能直接使用未调转顺序的LinkedBlockingDeque
   *
   * @see Collections#asLifoQueue()
   */
  public static <E> Queue<E> createConcurrentStack() {
    return (Queue<E>) Collections.asLifoQueue(newConcurrentNonBlockingDeque());
  }

  //////////////// 特殊类型Queue：LRUQueue ///////////

  /**
   * LRUQueue, 如果Queue已满，则删除最旧的元素.
   * <p>
   * 内部实现是ArrayDeque
   */
  public static <E> EvictingQueue<E> createLRUQueue(int maxSize) {
    return EvictingQueue.create(maxSize);
  }

}
