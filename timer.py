"""CSC148 Basic Timing Tools

=== CSC148 Fall 2016 ===
Diane Horton and David Liu
Department of Computer Science,
University of Toronto

=== Module description ===
This module contains a Timer class which can be used to measure the time
taken when executing a block of Python code.

Timer is used as a context manager; run help(Timer) to see example usage
for this class.

For more resources to learn about time profiling in Python, check out
https://docs.python.org/3.5/library/profile.html.
"""
import time


class Timer:
    """A Python context manager used to measure and output the amount of time
    a block of code takes.

    === Basic Usage ===

    Put the code to be timed inside a "with" block, and call the Timer
    constructor with a label.

    The code will be executed, and the amount of time taken will be printed.

    >>> with Timer('Some code'):
    ...     assert True
    Some code took 3.54532 seconds

    If you us an "as" clause to give the Timer object a name, after the
    code has finished, you can access the amount of time it required to
    execute.

    >>> with Timer('do stuff') as my_timer:
    ...     assert True
    >>> do stuff took 3.54532 seconds
    >>> my_timer.interval
    3.54532

    === Attributes ===
    @type label: str
        A label to describe the block of code.
    @type interval: float | None
        The amount of time the block took, or None when the block is first
        created.
    """
    def __init__(self, label='Block', storage=None, is_verbose=True):
        """Initialize a Timer.

        @type self: Timer
        @type label: str
            a label to describe the block of code
        @type storage: list | None
            A place to store the time of the code.
            A tuple (label, time) gets appended to the list
            when the block ends.
        @type is_verbose: bool
        @rtype: None
        """
        self.label = label
        self._storage = storage
        self._is_verbose = is_verbose
        self.interval = None

    def __enter__(self):
        """Enter a timed context.

        @type self: Timer
        @rtype: Timer
        """
        self.start = time.perf_counter()
        return self

    def __exit__(self, exc_type, exc_value, exc_trace):
        """Exit a timed context.

        @type self: Timer
        @rtype: str
        """
        self.end = time.perf_counter()
        self.interval = self.end - self.start
        if self._is_verbose:
            print('{label} took {time} seconds'.format(label=self.label,
                                                       time=self.interval))

        if self._storage is not None:
            self._storage.append((self.label, self.interval))

        return False
