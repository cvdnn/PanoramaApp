package com.arashivision.onecamera.camerarequest;

public class GyroOptions {
    public IndexRange index_range;
    public TimeRange time_range;

    public class IndexRange {
        public int count;
        public int start;

        public IndexRange() {
        }
    }

    public class TimeRange {
        public int duration;
        public int start;

        public TimeRange() {
        }
    }

    private IndexRange getIndex_range() {
        return this.index_range;
    }

    private TimeRange getTime_range() {
        return this.time_range;
    }

    private boolean hasIndexRange() {
        return this.index_range != null;
    }

    private boolean hasTimeRange() {
        return this.time_range != null;
    }
}
