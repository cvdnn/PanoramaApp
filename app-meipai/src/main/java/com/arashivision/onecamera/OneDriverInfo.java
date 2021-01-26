package com.arashivision.onecamera;

public class OneDriverInfo {

    public static class AudioChannel {
        public static final int MONO = 1;
        public static final int STEREO = 2;
    }

    public static class AudioCodec {
        public static final int ADTS = 1;
        public static final int RAW = 0;
    }

    public static class BlueToothConstants {

        public static class BleError {
            public static final int BLE_DISCONNECT = 501;
            public static final int BLE_NOTIFY_ERROR = 402;
            public static final int BLE_NO_PERMISSION = 403;
            public static final int BLE_READ_RSSI = 404;
            public static final int BLE_WRITE_ERROR = 401;
        }
    }

    public static class KeyTimePointType {
        public static final int END = 2;
        public static final int INSTANT = 0;
        public static final int START = 1;
    }

    public static class MultiVideoMode {
        public static final int DUAL = 3;
        public static final int SINGLE_OFF_SIDE = 2;
        public static final int SINGLE_SCREEN_SIDE = 1;
    }

    public static class MultiVideoOptions {
        public static final String PHOTOGRAPHY_INTERNAL_FLOWSTATE = "photography_flowstate";
        public static final String RESOLUTION = "resolution";
    }

    public static class Notification {

        public static class Authorization {
            public static final int REJECT = 1;
            public static final int SUCCESS = 0;
            public static final int TIMEOUT = 2;
        }

        public static class CardState {
            public static final int STOR_CS_INVALID_FORMAT = 3;
            public static final int STOR_CS_NOCARD = 1;
            public static final int STOR_CS_NOSPACE = 2;
            public static final int STOR_CS_OTHER_ERROR = 5;
            public static final int STOR_CS_PASS = 0;
            public static final int STOR_CS_WPCARD = 4;
        }

        public static class ErrorCode {
            public static final int DROP_FRAMES = 6;
            public static final int LOW_CARD_SPEED = 4;
            public static final int MUXER_STREAM_ERROR = 5;
            public static final int OTHER_SITUATION = 2;
            public static final int OVER_FILE_NUMBER_LIMIT = 3;
            public static final int OVER_TIME_LIMIT = 0;
            public static final int STORAGE_FULL = 1;
        }

        public static class KeyId {
            public static final int F0_DOUBLE_PRESS = 1;
            public static final int F0_SHORT_PRESS = 0;
            public static final int F0_TRIPLE_PRESS = 2;
        }

        public static class ShutDownErrorCode {
            public static final int BATTERT_RUNOUT = 0;
            public static final int TEMPERATURE_OVERLIMIT = 1;
        }

        public static class TakePictureState {
            public static final int COMPRESS = 1;
            public static final int SHUTTER = 0;
            public static final int WRITE_FILE = 2;
        }

        public static class UsbError {
            public static final int ERR_CAMERA_BASE = 0;
            public static final int ERR_DEV_DETACH = -121;
            public static final int ERR_NO_DEV = -121;
            public static final int ERR_SOCKET_READ = -211;
            public static final int ERR_SOCKET_TIMEOUT = -19;
            public static final int ERR_SOCKET_WRITE = -212;
            public static final int ERR_USB = -120;
        }

        public static class UsbState {
            public static final int ERROR = 1;
            public static final int NOT_START = 2;
            public static final int SYNCED = 0;
        }
    }

    public static class Options {
        public static final String ACC_FULL_SCALE_RANGE = "acc_range";
        public static final String ACTIVATE_TIME = "activate_time";
        public static final String APOPTION_SYSTEM = "sys_adoption";
        public static final String AUDIO_BITRATE = "audio_bitrate";
        public static final String AUDIO_SAMPLERATE = "audio_samplerate";
        public static final String AUTHORIZATION_ID = "authorization_id";
        public static final String BATTERY_LEVEL = "battery_status-battery_level";
        public static final String BATTERY_POWER_TYPE = "battery_status-power_type";
        public static final String BATTERY_SCALE = "battery_status-battery_scale";
        public static final String BT_REMOTE_TYPE = "bt_remote_type";
        public static final String BT_REMOTE_VERSION = "bt_remote_version";
        public static final String BUTTON_PRESS_CLICK = "pressoptions-click";
        public static final String BUTTON_PRESS_DOUBLE_CLICK = "pressoptions-doubleclick";
        public static final String BUTTON_PRESS_LONG_PRESS = "pressoptions-longpress";
        public static final String BUTTON_PRESS_SHUTDOWN_CLICK = "pressoptions-shutdown_click";
        public static final String BUTTON_PRESS_SHUTDOWN_SHORT_PRESS = "pressoptions-shutdown_short_press";
        public static final String BUTTON_PRESS_TRIPLE_CLICK = "pressoptions-tripleclick";
        public static final String CALIBRATION_OFFSET = "calibration_offset";
        public static final String CALIBRATION_OFFSET_3D = "calibration_offset_3d";
        public static final String CAMERA_TYPE = "camera_type";
        public static final String CAPTURE_TIME_LIMIT = "capture_time_limit";
        public static final String CPU_TYPE = "cpu_type";
        public static final String EVO_STATUS_MODE = "evo_status_mode";
        public static final String FIRMWAREREVISION = "firmwarerevision";
        public static final String GPS_TIMEOUT = "gps_timeout";
        public static final String GYRO_FILTER = "gyro_filter";
        public static final String GYRO_FULL_SCALE_RANGE = "gyro_range";
        public static final String GYRO_SAMPLE_RATE = "gyro_sample_rate";
        public static final String IMAGE_FLICKER = "image_flicker";
        public static final String INTERNAL_FLOWSTATE = "internal_flowstate";
        public static final String IS_SELFIE = "is_selfie";
        public static final String LENS_INDEX = "lens_index";
        public static final String LOCAL_TIME = "local_time";
        public static final String LOG_MODE = "log_mode";
        public static final String MCTF_ENABLE = "mctf_enable";
        public static final String MEDIA_OFFSET = "media_offset";
        public static final String MEDIA_OFFSET_3D = "media_offset_3d";
        public static final String MEDIA_TIME = "media_time";
        public static final String MUTE = "mute";
        public static final String ONE_UUID = "uuid";
        public static final String ORIGIN_OFFSET = "origin_offset";
        public static final String ORIGIN_OFFSET_3D = "origin_offset_3d";
        public static final String PHOTO_SIZE_HEIGHT = "photo_size-height";
        public static final String PHOTO_SIZE_WIDTH = "photo_size-width";
        public static final String PHOTO_SUB_MODE = "photo_sub_mode";
        public static final String QUALITY_SETTING = "quality_setting";
        public static final String REMAINIG_PICTURES = "remaining_pictures";
        public static final String REMAINING_CAPTURE_TIME = "remaining_capture_time";
        public static final String SECOND_STREAM_RES = "second_stream_res";
        public static final String SELF_TIMER = "self_timer";
        public static final String SENSOR0_SERIAL_VR360 = "sensor0_serial_vr360";
        public static final String SENSOR1_SERIAL_VR360 = "sensor1_serial_vr360";
        public static final String SENSOR_SERIAL_VR180 = "sensor_serial_vr180";
        public static final String SERIAL_NUMBER = "serial_number";
        public static final String SPORT_MODE_ENABLE = "sport_mode_enable";
        public static final String STORAGE_CARD_STATE = "storage_state-card_state";
        public static final String STORAGE_FREE_SPACE = "storage_state-free_space";
        public static final String STORAGE_TOTAL_SPACE = "storage_state-total_space";
        public static final String TAKE_RAW_PICTURE = "take_raw_picture";
        public static final String TIME_ZONE = "time_zone_seconds_from_gmt";
        public static final String VIDEO_BITRATE = "video_bitrate";
        public static final String VIDEO_ENCODE_TYPE = "video_encode_type";
        public static final String VIDEO_RESULUTION_FPS = "video_resolution-fps";
        public static final String VIDEO_RESULUTION_HEIGHT = "video_resolution-height";
        public static final String VIDEO_RESULUTION_WIDTH = "video_resolution-width";
        public static final String VIDEO_SUB_MODE = "video_sub_mode";
        public static final String WIFI_CH = "wifi_channel";
        public static final String WIFI_CH_COUNTY = "wifi_channel_country";
        public static final String WIFI_MODE = "wifi_mode";
        public static final String WIFI_PWD = "wifi_password";
        public static final String WIFI_SSID = "wifi_ssid";
        public static final String WIFI_STATUS = "wifi_status";

        public static class AccFullScaleRange {
            public static final int RANGE_16G = 3;
            public static final int RANGE_2G = 0;
            public static final int RANGE_4G = 1;
            public static final int RANGE_8G = 2;
        }

        public static class AdoptionSystem {
            public static final int PHONE_ANDROID = 1;
            public static final int PHONE_IOS = 0;
        }

        public static class BTRemoteType {
            public static final int BT_REMOTE_WITHOUT_GPS = 1;
            public static final int BT_REMOTE_WITH_GPS = 2;
            public static final int UNKNOWN_BT_REMOTE = 0;
        }

        public static class ButtonPressMode {
            public static final int ACTION_CALIBRATE_GYRO = 13;
            public static final int ACTION_INTERVAL_VIDEO = 10;
            public static final int ACTION_STATIC_TIMELAPSE = 12;
            public static final int ACTION_TIMELAPSE_VIDEO = 8;
            public static final int CAPTURE = 4;
            public static final int DO_NOTHING = 1;
            public static final int DO_NOT_CHANGE = 0;
            public static final int HIGH_FRAME_RATE = 7;
            public static final int INTERVAL_SHOOTING = 9;
            public static final int SELFTIMER = 5;
            public static final int SHUT_DOWN = 2;
            public static final int TAKE_HDR_IMAGE = 11;
            public static final int TAKE_PICTURE = 3;
        }

        public static class CaptureMode {
            public static final int MODE_BULLETTIME = 2;
            public static final int MODE_HDR = 3;
            public static final int MODE_NORMAL = 1;
            public static final int MODE_TIMESHIFT = 4;
        }

        public static class EVOStatusMode {
            public static final int DEGREE180 = 1;
            public static final int DEGREE360 = 2;
            public static final int DEGREE_NONE = 0;
        }

        public static class GyroFullScaleRange {
            public static final int RANGE_1000DPS = 2;
            public static final int RANGE_2000DPS = 3;
            public static final int RANGE_250DPS = 0;
            public static final int RANGE_500DPS = 1;
        }

        public static class ImageFlickerType {
            public static final int IMAGE_FLICKER_50HZ = 2;
            public static final int IMAGE_FLICKER_60HZ = 1;
            public static final int IMAGE_FLICKER_AUTO = 0;
        }

        public static class PhotoSize {
            public static final int Size_6912_3456 = 0;
        }

        public static class PhotoSubMode {
            public static final int AEB_NIGHT = 4;
            public static final int PHOTO_BURST = 3;
            public static final int PHOTO_HDR = 1;
            public static final int PHOTO_INTERVAL = 2;
            public static final int PHOTO_SINGLE = 0;
        }

        public static class PowerType {
            public static final int ADAPTER = 1;
            public static final int BATTERY = 0;
        }

        public static class QualitySetting {
            public static final int HIGH_QUALITY = 0;
            public static final int LOW_QUALITY = 1;
        }

        public static class TempState {
            public static final int TEMP_ALERT = 1;
            public static final int TEMP_HIGH = 3;
            public static final int TEMP_LOW = 0;
            public static final int TEMP_MIDDLE = 2;
        }

        public static class VideoEncodeType {
            public static final int ENCODE_H264 = 0;
            public static final int ENCODE_H265 = 1;
        }

        public static class VideoResolution {
            public static final int RES_1024_512P30 = 35;
            public static final int RES_1152_768P30 = 45;
            public static final int RES_1280_720P30 = 43;
            public static final int RES_1280_960P30 = 44;
            public static final int RES_1440_720P30 = 9;
            public static final int RES_1920_1080P24 = 53;
            public static final int RES_1920_1080P25 = 52;
            public static final int RES_1920_1080P60 = 40;
            public static final int RES_1920_1080p120 = 28;
            public static final int RES_1920_1080p200 = 26;
            public static final int RES_1920_1080p240 = 27;
            public static final int RES_1920_1080p30 = 29;
            public static final int RES_1920_1440P24 = 59;
            public static final int RES_1920_1440P25 = 58;
            public static final int RES_1920_1440P30 = 42;
            public static final int RES_1920_960P20 = 22;
            public static final int RES_1920_960P30 = 2;
            public static final int RES_2048_512P120 = 4;
            public static final int RES_2176_1088P30 = 16;
            public static final int RES_2240_1120P24 = 8;
            public static final int RES_2240_1120P30 = 7;
            public static final int RES_2560_1280P30 = 1;
            public static final int RES_2560_1280P60 = 3;
            public static final int RES_2720_1530P24 = 51;
            public static final int RES_2720_1530P25 = 50;
            public static final int RES_2720_1530P30 = 39;
            public static final int RES_2720_1530P60 = 38;
            public static final int RES_2720_1530p100 = 25;
            public static final int RES_2720_2040P24 = 57;
            public static final int RES_2720_2040P25 = 56;
            public static final int RES_2720_2040P30 = 41;
            public static final int RES_2880_2880P24 = 20;
            public static final int RES_2880_2880P25 = 19;
            public static final int RES_2880_2880P30 = 10;
            public static final int RES_3008_1504P100 = 13;
            public static final int RES_3040_1520P30 = 15;
            public static final int RES_3072_1536P30 = 6;
            public static final int RES_3328_832P60 = 5;
            public static final int RES_3840_1920P20 = 21;
            public static final int RES_3840_1920P30 = 0;
            public static final int RES_3840_1920P50 = 12;
            public static final int RES_3840_1920P60 = 11;
            public static final int RES_3840_2160P24 = 49;
            public static final int RES_3840_2160P25 = 48;
            public static final int RES_3840_2160p30 = 24;
            public static final int RES_3840_2160p60 = 23;
            public static final int RES_4000_3000P24 = 55;
            public static final int RES_4000_3000P25 = 54;
            public static final int RES_4000_3000p30 = 31;
            public static final int RES_424_240P15 = 34;
            public static final int RES_480_240P30 = 18;
            public static final int RES_5312_2988P24 = 47;
            public static final int RES_5312_2988P25 = 46;
            public static final int RES_5312_2988P30 = 37;
            public static final int RES_5472_3078p30 = 30;
            public static final int RES_640_320P30 = 36;
            public static final int RES_720_360P30 = 17;
            public static final int RES_720_406P30 = 33;
            public static final int RES_854_640P30 = 32;
            public static final int RES_960_480P30 = 14;
        }

        public static class VideoSubMode {
            public static final int VIDEO_BULLETTIME = 1;
            public static final int VIDEO_HDR = 3;
            public static final int VIDEO_NORMAL = 0;
            public static final int VIDEO_TIMELAPSE = 2;
            public static final int VIDEO_TIMESHIFT = 4;
        }

        public static class WIFI_MODE_TYPE {
            public static final int AP = 0;
            public static final int P2P = 2;
            public static final int STA = 1;
        }

        public static class WifiStatus {
            public static final int AUTO = 0;
            public static final int ON = 1;
        }
    }

    public static class PhotoOptionsConstants {

        public static class AEMeterMode {
            public static final int AE_METER_MODE_MANUAL = 1;
            public static final int AE_METER_MODE_NORMAL = 0;
        }

        public static class Flicker {
            public static final int FLICKER_50HZ = 2;
            public static final int FLICKER_60HZ = 1;
            public static final int FLICKER_AUTO = 0;
        }

        public static class FovType {
            public static final int FOV_TYPE_LINEAR = 1;
            public static final int FOV_TYPE_NARROW = 3;
            public static final int FOV_TYPE_ULTRAWIDE = 2;
            public static final int FOV_TYPE_WIDE = 0;
        }

        public static class FunctionMode {
            public static final int FUNCMODE_HIGH_FRAME_RATE = 4;
            public static final int FUNCMODE_INTERVAL_SHOOTING = 3;
            public static final int FUNCMODE_LIVE_STREAM = 1;
            public static final int FUNCMODE_NORMAL = 0;
            public static final int FUNCMODE_TIMELAPSE = 2;
            public static final int FUNCTION_MODE_AEB_NIGHT_IMAGE = 13;
            public static final int FUNCTION_MODE_BURST = 5;
            public static final int FUNCTION_MODE_HDR_IMAGE = 8;
            public static final int FUNCTION_MODE_HDR_VIDEO = 9;
            public static final int FUNCTION_MODE_INTERVAL_VIDEO = 10;
            public static final int FUNCTION_MODE_NORMAL_IMAGE = 6;
            public static final int FUNCTION_MODE_NORMAL_VIDEO = 7;
            public static final int FUNCTION_MODE_STATIC_TIMELAPSE = 11;
            public static final int FUNCTION_MODE_TIMESHIFT = 12;
        }

        public static class PREVIEW_SPORT_LEVEL {
            public static final int PREVIEW_SPORT_AUTO = 0;
            public static final int PREVIEW_SPORT_FAST = 1;
            public static final int PREVIEW_SPORT_FASTER = 2;
        }

        public static class Program {
            public static final int ADAPTIVE = 4;
            public static final int AUTO = 0;
            public static final int ISO_PRIORITY = 1;
            public static final int MANUAL = 3;
            public static final int SHUTTER_PRIORITY = 2;
        }

        public static class RAW_CAPTURE_TYPE {
            public static final int RAW_CAPTURE_DNG = 1;
            public static final int RAW_CAPTURE_OFF = 0;
            public static final int RAW_CAPTURE_RAW = 2;
        }

        public static class VideoResolution {
            public static final int RES_1024_512P30 = 35;
            public static final int RES_1152_768P30 = 45;
            public static final int RES_1280_720P30 = 43;
            public static final int RES_1280_960P30 = 44;
            public static final int RES_1440_720P30 = 9;
            public static final int RES_1920_1080P24 = 53;
            public static final int RES_1920_1080P25 = 52;
            public static final int RES_1920_1080P60 = 40;
            public static final int RES_1920_1080p120 = 28;
            public static final int RES_1920_1080p200 = 26;
            public static final int RES_1920_1080p240 = 27;
            public static final int RES_1920_1080p30 = 29;
            public static final int RES_1920_1440P24 = 59;
            public static final int RES_1920_1440P25 = 58;
            public static final int RES_1920_1440P30 = 42;
            public static final int RES_1920_960P20 = 22;
            public static final int RES_1920_960P30 = 2;
            public static final int RES_2048_512P120 = 4;
            public static final int RES_2176_1088P30 = 16;
            public static final int RES_2240_1120P24 = 8;
            public static final int RES_2240_1120P30 = 7;
            public static final int RES_2560_1280P30 = 1;
            public static final int RES_2560_1280P60 = 3;
            public static final int RES_2720_1530P24 = 51;
            public static final int RES_2720_1530P25 = 50;
            public static final int RES_2720_1530P30 = 39;
            public static final int RES_2720_1530P60 = 38;
            public static final int RES_2720_1530p100 = 25;
            public static final int RES_2720_2040P24 = 57;
            public static final int RES_2720_2040P25 = 56;
            public static final int RES_2720_2040P30 = 41;
            public static final int RES_2880_2880P24 = 20;
            public static final int RES_2880_2880P25 = 19;
            public static final int RES_2880_2880P30 = 10;
            public static final int RES_3008_1504P100 = 13;
            public static final int RES_3040_1520P30 = 15;
            public static final int RES_3072_1536P30 = 6;
            public static final int RES_3328_832P60 = 5;
            public static final int RES_3840_1920P20 = 21;
            public static final int RES_3840_1920P30 = 0;
            public static final int RES_3840_1920P50 = 12;
            public static final int RES_3840_1920P60 = 11;
            public static final int RES_3840_2160P24 = 49;
            public static final int RES_3840_2160P25 = 48;
            public static final int RES_3840_2160p30 = 24;
            public static final int RES_3840_2160p60 = 23;
            public static final int RES_4000_3000P24 = 55;
            public static final int RES_4000_3000P25 = 54;
            public static final int RES_4000_3000p30 = 31;
            public static final int RES_424_240P15 = 34;
            public static final int RES_480_240P30 = 18;
            public static final int RES_5312_2988P24 = 47;
            public static final int RES_5312_2988P25 = 46;
            public static final int RES_5312_2988P30 = 37;
            public static final int RES_5472_3078p30 = 30;
            public static final int RES_640_320P30 = 36;
            public static final int RES_720_360P30 = 17;
            public static final int RES_720_406P30 = 33;
            public static final int RES_854_640P30 = 32;
            public static final int RES_960_480P30 = 14;
        }

        public static class WhiteBalance {
            public static final int WB_2700K = 1;
            public static final int WB_4000K = 2;
            public static final int WB_5000K = 3;
            public static final int WB_6500K = 4;
            public static final int WB_7500K = 5;
            public static final int WB_AUTO = 0;
        }
    }

    public static class PhotographyOptions {
        public static final String AEB_CAPTURE_NUM = "aeb_capture_num";
        public static final String AE_MANUAL_METER_WEIGHT = "manual_meter_weights";
        public static final String AE_METER_MODE = "meter_mode";
        public static final String BRIGHTNESS = "brightness";
        public static final String CHANNEL = "channel";
        public static final String CONTRAST = "contrast";
        public static final String EV_INDEX = "ev_index";
        public static final String EXPOSURE_BIAS = "exposure_bias";
        public static final String EXPOSURE_MANUAL = "exposure_manual-relate_mode";
        public static final String EXPOSURE_MODE = "exposure_mode";
        public static final String EXPOSURE_PROG = "exposure_prog-mode";
        public static final String FLICKER = "flicker";
        public static final String FLOW_STATE_ENABLE = "flowstate_enable";
        public static final String FOV_TYPE = "fov_type";
        public static final String HUE = "hue";
        public static final String LOG_MODE_ENABLE = "log_mode_enable";
        public static final String LONG_EXPOSURE_MANUAL = "long_exposure_manual";
        public static final String PHOTOGRAPHY_SELF_TIMER = "photo_self_timer";
        public static final String PHOTO_GRAPHY_BITRATE = "video_bitrate";
        public static final String PHOTO_SIZE_ID = "photo_size_id";
        public static final String PREVIEW_MCTF_ENABLE = "preview_mctf_enable";
        public static final String PREVIEW_SPORT_LEVEL = "preview_sport_level";
        public static final String PREVIEW_SPORT_MODE_ENABLE = "preview_sport_mode_enable";
        public static final String RAW_CAPTURE_TYPE = "raw_capture_type";
        public static final String RECORD_DURAION = "record_duration";
        public static final String RECORD_RESOLUTION = "record_resolution";
        public static final String SATURATION = "saturation";
        public static final String SHARPNESS = "sharpness";
        public static final String STILL_EXPOSURE_OPTIONS = "still_exposure_options-program";
        public static final String VIDEO_EXPOSURE_OPTIONS = "video_exposure_options-program";
        public static final String VIDEO_ISO_TOP_LIMIT = "video_iso_top_limit";
        public static final String WHITE_BALANCE = "white_balance";
    }

    public static class RecordFormat {
        public static final String VIDEO_FORMAT_FLV = "flv";
        public static final String VIDEO_FORMAT_MP4 = "mp4";
    }

    public static class Request {

        public static class BTPeripheralType {
            public static final int BTPERIPHERALTYPE_ALL = 0;
            public static final int BTPERIPHERALTYPE_REMOTE = 1;
        }

        public static class ExtraType {
            public static final int EXTRA_TYPE_ALL = 0;
            public static final int EXTRA_TYPE_EXPOSURE = 4;
            public static final int EXTRA_TYPE_EXT_THUMBNAIL = 5;
            public static final int EXTRA_TYPE_GYRO = 3;
            public static final int EXTRA_TYPE_METADATA = 1;
            public static final int EXTRA_TYPE_THUMBNAIL = 2;
        }

        public static class ImageMode {
            public static final int AEB = 1;
            public static final int AEB_NIGHT = 4;
            public static final int BURST = 3;
            public static final int NORMAL = 0;
            public static final int RAW = 2;
        }

        public static class IperfMode {
            public static final int TCP = 0;
            public static final int UDP = 1;
        }

        public static class KeyTimeDetial {
            public static final String HIGHLIGHT = "com.insta360.keyTime.highlight";
            public static final String SLOWDOWN = "com.insta360.keyTime.slowdown";
            public static final String TRACK_THAT = "com.insta360.keyTime.trackThat";
        }

        public static class KeyTimeType {
            public static final int END = 2;
            public static final int INSTANT = 0;
            public static final int START = 1;
        }

        public static class MediaType {
            public static final int MEDIATYPE_DNG = 3;
            public static final int MEDIATYPE_JPG = 5;
            public static final int MEDIATYPE_MP4 = 4;
            public static final int MEDIATYPE_PHOTO = 1;
            public static final int MEDIATYPE_VIDEO = 0;
            public static final int MEDIATYPE_VIDEO_AND_PHOTO = 2;
        }

        public static class StandbyMode {
            public static final int STANDBY_MODE_LOW_ENERGY = 1;
            public static final int STANDBY_MODE_UNKNOWN = 0;
            public static final int STANDBY_MODE_WAKE_UP = 2;
        }

        public static class TimelapseMode {
            public static final int STATIC_TIMELAPSE_VIDEO = 3;
            public static final int TIMELAPSE_INTERVAL_SHOOTING = 2;
            public static final int TIMELAPSE_INTERVAL_VIDEO = 4;
            public static final int TIMELAPSE_VIDEO = 1;
        }
    }

    public static class Response {
        public static final int RESPONSE_SUC = 0;

        public static class Authenticate {
            public static final int AUTHORIZED = 0;
            public static final int SYSTEMBUSY = 2;
            public static final int UNAUTHORIZED = 1;
        }

        public static class ButtonState {
            public static final int BUTTON_BOTH_DONW = 3;
            public static final int BUTTON_NONE_DONW = 4;
            public static final int BUTTON_POWER_DONW = 1;
            public static final int BUTTON_SHOOT_DONW = 2;
            public static final int BUTTON_UNKNOWN = 0;
        }

        public static class CameraCaptureState {
            public static final int AEB_NIGHT_SHOOTING = 14;
            public static final int BULLET_TIME_CAPTURE = 7;
            public static final int BURST_SHOOTING = 10;
            public static final int HDR_CAPTURE = 9;
            public static final int HDR_SHOOTING = 5;
            public static final int INTERVAL_SHOOTING_CAPTURE = 3;
            public static final int INTERVAL_VIDEO_CAPTURE = 12;
            public static final int NORMAL_CAPTURE = 1;
            public static final int NOT_CAPTURE = 0;
            public static final int SELF_TIMER_SHOOTING = 6;
            public static final int SETTINGS_NEW_VALUE = 8;
            public static final int SINGLE_SHOOTING = 4;
            public static final int STATIC_TIMELAPSE_SHOOTING = 11;
            public static final int TIMELAPSE_CAPTURE = 2;
            public static final int TIMESHIFT_CAPTURE = 13;
            public static final int UNKNOWN_STATE = 100;
        }

        public static class InfoType {
            public static final int BATTERY_LOW = 3;
            public static final int BATTERY_UPDATE = 2;
            public static final int BLUETOOTHSTATUS_TEST = 92;
            public static final int BT_CONNECTED_TO_PERIPHERAL = 13;
            public static final int BT_DISCONNECTED_PERIPHERAL = 14;
            public static final int BT_DISCOVER_PERIPHERAL = 12;
            public static final int BUTTON_PRESSED = 7;
            public static final int CALIBRATE_GYRO = 65;
            public static final int CAMERA_STATUS_NOTIFY = 77;
            public static final int CAM_TEMPERATURE_VALUE = 96;
            public static final int CANCEL_AUTHORIZATION = 79;
            public static final int CANCEL_CAPTURE = 52;
            public static final int CAPTURE_STILL_IMAGE_STATE_UPDATE = 9;
            public static final int CHECK_AUTHORIZATION = 78;
            public static final int CLOSE_CAMERA_OLED = 83;
            public static final int CLOSE_CAMERA_WIFI = 70;
            public static final int CLOSE_IPERF = 88;
            public static final int CONNECT_TO_BT = 74;
            public static final int DELETE_FILES = 58;
            public static final int DISCONNECT_BT = 75;
            public static final int ERASE_SD_CARD = 64;
            public static final int FACTORY_AGE_TEST_STATUS = 106;
            public static final int FACTORY_BAD_POINT_TEST = 110;
            public static final int FACTORY_BLACKLEVEL_TEST = 109;
            public static final int FACTORY_BUTTON_STATUS_TEST = 105;
            public static final int FACTORY_DSP_LINK_TEST = 107;
            public static final int FACTORY_GYRO = 111;
            public static final int FACTORY_LCD_CLOSE_TESTT = 104;
            public static final int FACTORY_USB_SPEED_TEST = 103;
            public static final int FACTORY_VIBRATE = 112;
            public static final int FACTORY_WHITEBLANCE_TEST = 108;
            public static final int FIRMWARE_UPGRADE_COMPLETE = 0;
            public static final int GET_CONNECT_BT = 71;
            public static final int GET_CURRENT_CAPTURE_STATUS = 72;
            public static final int GET_FILEINFO_LIST = 76;
            public static final int GET_FILE_EXTRA = 57;
            public static final int GET_FILE_LIST = 59;
            public static final int GET_FLOWSTATE_ENABLE = 99;
            public static final int GET_GYRO_COUNT = 85;
            public static final int GET_IPERF_AVERAGE = 86;
            public static final int GET_MINI_THUMBNAIL = 66;
            public static final int GET_MULTI_VIDEO_MODE = 201;
            public static final int GET_OPTIONS = 54;
            public static final int GET_PHOTOGRAPHY_OPTIONS = 56;
            public static final int GET_SINGLE_SENSOR = 203;
            public static final int GET_SYNC_CAPTURE_MODE = 94;
            public static final int GET_TIMELAPSE_OPTIONS = 61;
            public static final int LED_TEST = 89;
            public static final int NOTIFICATION_BT_REMOTE_VER_UPDATED = 17;
            public static final int NOTIFICATION_SYNC_BUTTON_TRIGGER = 16;
            public static final int NOTIFICATION_SYNC_CAPTURE_MODE_UPDATE = 15;
            public static final int NOTIFY_AUTHORIZATION = 80;
            public static final int NOTIFY_TIMELAPSE_STATUS_UPDATE = 81;
            public static final int OPEN_CAMERA_OLED = 82;
            public static final int OPEN_CAMERA_WIFI = 69;
            public static final int OPEN_IPERF = 87;
            public static final int PHONE_INSERT = 11;
            public static final int REBOOT_CAMERA = 68;
            public static final int RECORD_AUTO_SPLIT = 1;
            public static final int RECORD_STOPPED = 8;
            public static final int SCAN_BT = 73;
            public static final int SET_FILE_EXTRA = 60;
            public static final int SET_FLOWSTATE_ENABLE = 98;
            public static final int SET_KEYTIME_POINT = 97;
            public static final int SET_MULTI_VIDEO_MODE = 200;
            public static final int SET_OPTIONS = 53;
            public static final int SET_PHOTOGRAPHY_OPTIONS = 55;
            public static final int SET_SINGLE_SENSOR = 202;
            public static final int SET_STANDBY_MODE = 95;
            public static final int SET_SYNC_CAPTURE_MODE = 93;
            public static final int SET_TIMELAPSE_OPTIONS = 62;
            public static final int SHUTDOWN = 4;
            public static final int SPEAKER_TEST = 90;
            public static final int START_LIVE_STREAM = 50;
            public static final int STOP_LIVE_STREAM = 51;
            public static final int STORAGE_FULL = 6;
            public static final int STORAGE_UPDATE = 5;
            public static final int TEST_SD_CARD_SPEED = 67;
            public static final int UNKNOWN = 100;
            public static final int UPLOAD_GPS = 84;
            public static final int WIFISTATUS_TEST = 91;
        }

        public static class OpState {
            public static final int CANCELED = 3;
            public static final int COMPLETE = 1;
            public static final int FAILED = 2;
            public static final int STARTED = 0;
        }

        public static class StreamType {
            public static final int AUDIO_STREAM = 16;
            public static final int GYRO_STREAM = 48;
            public static final int UNKNOWN = 255;
            public static final int VIDEO_EXPOSURE_TIME = 64;
            public static final int VIDEO_STREAM = 32;
            public static final int VIDEO_STREAM_L = 33;
            public static final int VIDEO_STREAM_R = 34;
        }

        public static class SyncCaptureModeInfo {
            public static final int SYNC_MODE_BULLETTIME_VIDEO = 8;
            public static final int SYNC_MODE_BURST_PHOTO = 7;
            public static final int SYNC_MODE_HDR_IMAGE = 3;
            public static final int SYNC_MODE_HDR_VIDEO = 4;
            public static final int SYNC_MODE_INTERVAL_IMAGE = 5;
            public static final int SYNC_MODE_NORMAL_IMAGE = 1;
            public static final int SYNC_MODE_NORMAL_VIDEO = 2;
            public static final int SYNC_MODE_TIMELAPSE_VIDEO = 6;
            public static final int SYNC_MODE_UNKNOWN = 0;
        }
    }

    public static class VideoFormat {
        public static final int CAMERA_FRAME_FORMAT_FRAME_BASED_H264 = 0;
    }
}
