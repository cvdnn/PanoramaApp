package d.m.a;

import android.content.res.AssetManager.AssetInputStream;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.arashivision.arvbmg.render.camera.HeadTrackerController;
import com.arashivision.insta360.basemedia.export.task.single.params.image.IExportImageParams;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidubce.BceConfig;
import com.facebook.stetho.dumpapp.Framer;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* compiled from: ExifInterface */
public class a {
    public static final byte[] A = {109, 105, 102, Framer.STDOUT_FRAME_PREFIX};
    public static final byte[] B = {104, 101, 105, 99};
    public static final byte[] C = {79, 76, 89, 77, 80, 0};
    public static final byte[] D = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    public static final byte[] E = {-119, 80, 78, 71, 13, 10, 26, 10};
    public static final byte[] F = {101, 88, 73, 102};
    public static final byte[] G = {73, 72, 68, 82};
    public static final byte[] H = {73, 69, 78, 68};
    public static final byte[] I = {82, 73, 70, 70};
    public static final byte[] J = {87, 69, 66, 80};
    public static final byte[] K = {69, 88, 73, 70};
    public static final byte[] L = "VP8X".getBytes(Charset.defaultCharset());
    public static final byte[] M = "VP8L".getBytes(Charset.defaultCharset());
    public static final byte[] N = "VP8 ".getBytes(Charset.defaultCharset());
    public static final byte[] O = "ANIM".getBytes(Charset.defaultCharset());
    public static final byte[] P = "ANMF".getBytes(Charset.defaultCharset());
    public static SimpleDateFormat Q;
    public static final String[] R = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    public static final int[] S = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    public static final byte[] T = {65, 83, 67, 73, 73, 0, 0, 0};
    public static final e[] U = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ImageWidth", 256, 3, 4), new e("ImageLength", SapiErrorCode.PHONE_NULL, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", HeadTrackerController.SCREEN_ORIENTATION_LANDSCAPE, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("Orientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", 700, 1)};
    public static final e[] V = {new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e("PixelXDimension", 40962, 3, 4), new e("PixelYDimension", 40963, 3, 4), new e("RelatedSoundFile", 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
    public static final e[] W = {new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e(IExportImageParams.KEY_EXIF_GPS_LATITUDE, 2, 5), new e("GPSLongitudeRef", 3, 2), new e(IExportImageParams.KEY_EXIF_GPS_LONGITUDE, 4, 5), new e("GPSAltitudeRef", 5, 1), new e(IExportImageParams.KEY_EXIF_GPS_ALTITUDE, 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5)};
    public static final e[] X = {new e("InteroperabilityIndex", 1, 2)};
    public static final e[] Y = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ThumbnailImageWidth", 256, 3, 4), new e("ThumbnailImageLength", SapiErrorCode.PHONE_NULL, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", HeadTrackerController.SCREEN_ORIENTATION_LANDSCAPE, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("ThumbnailOrientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
    public static final e Z = new e("StripOffsets", 273, 3);
    public static final e[] a0 = {new e("ThumbnailImage", 256, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)};
    public static final e[] b0 = {new e("PreviewImageStart", SapiErrorCode.PHONE_NULL, 4), new e("PreviewImageLength", 258, 4)};
    public static final e[] c0 = {new e("AspectFrame", 4371, 3)};
    public static final e[] d0;
    public static final e[][] e0;
    public static final e[] f0 = {new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};
    public static final e g0 = new e("JPEGInterchangeFormat", 513, 4);
    public static final e h0 = new e("JPEGInterchangeFormatLength", 514, 4);
    public static final HashMap<Integer, e>[] i0;
    public static final HashMap<String, e>[] j0;
    public static final HashSet<String> k0 = new HashSet<>(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));
    public static final HashMap<Integer, Integer> l0 = new HashMap<>();
    public static final Charset m0;
    public static final byte[] n0;
    public static final byte[] o0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(m0);
    public static final Pattern p0 = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    public static final boolean v = Log.isLoggable("ExifInterface", 3);
    public static final int[] w = {8, 8, 8};
    public static final int[] x = {8};
    public static final byte[] y = {-1, -40, -1};
    public static final byte[] z = {102, 116, 121, 112};

    /* renamed from: a reason: collision with root package name */
    public String f5062a;

    /* renamed from: b reason: collision with root package name */
    public FileDescriptor f5063b;

    /* renamed from: c reason: collision with root package name */
    public AssetInputStream f5064c;

    /* renamed from: d reason: collision with root package name */
    public int f5065d;

    /* renamed from: e reason: collision with root package name */
    public boolean f5066e;

    /* renamed from: f reason: collision with root package name */
    public final HashMap<String, d>[] f5067f = new HashMap[e0.length];

    /* renamed from: g reason: collision with root package name */
    public Set<Integer> f5068g = new HashSet(e0.length);

    /* renamed from: h reason: collision with root package name */
    public ByteOrder f5069h = ByteOrder.BIG_ENDIAN;

    /* renamed from: i reason: collision with root package name */
    public boolean f5070i;

    /* renamed from: j reason: collision with root package name */
    public boolean f5071j;
    public int k;
    public int l;
    public byte[] m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public boolean u;

    /* renamed from: d.m.a.a$a reason: collision with other inner class name */
    /* compiled from: ExifInterface */
    public class C0049a extends MediaDataSource {

        /* renamed from: a reason: collision with root package name */
        public long f5072a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ b f5073b;

        public C0049a(a aVar, b bVar) {
            this.f5073b = bVar;
        }

        public void close() throws IOException {
        }

        public long getSize() throws IOException {
            return -1;
        }

        public int readAt(long j2, byte[] bArr, int i2, int i3) throws IOException {
            if (i3 == 0) {
                return 0;
            }
            if (j2 < 0) {
                return -1;
            }
            try {
                if (this.f5072a != j2) {
                    if (this.f5072a >= 0 && j2 >= this.f5072a + ((long) this.f5073b.available())) {
                        return -1;
                    }
                    this.f5073b.a(j2);
                    this.f5072a = j2;
                }
                if (i3 > this.f5073b.available()) {
                    i3 = this.f5073b.available();
                }
                b bVar = this.f5073b;
                int read = bVar.f5076a.read(bArr, i2, i3);
                bVar.f5079d += read;
                if (read >= 0) {
                    this.f5072a += (long) read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f5072a = -1;
            return -1;
        }
    }

    /* compiled from: ExifInterface */
    public static class b extends InputStream implements DataInput {

        /* renamed from: e reason: collision with root package name */
        public static final ByteOrder f5074e = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: f reason: collision with root package name */
        public static final ByteOrder f5075f = ByteOrder.BIG_ENDIAN;

        /* renamed from: a reason: collision with root package name */
        public DataInputStream f5076a;

        /* renamed from: b reason: collision with root package name */
        public ByteOrder f5077b;

        /* renamed from: c reason: collision with root package name */
        public final int f5078c;

        /* renamed from: d reason: collision with root package name */
        public int f5079d;

        public b(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.f5077b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f5076a = dataInputStream;
            int available = dataInputStream.available();
            this.f5078c = available;
            this.f5079d = 0;
            this.f5076a.mark(available);
            this.f5077b = byteOrder;
        }

        public void a(long j2) throws IOException {
            int i2 = this.f5079d;
            if (((long) i2) > j2) {
                this.f5079d = 0;
                this.f5076a.reset();
                this.f5076a.mark(this.f5078c);
            } else {
                j2 -= (long) i2;
            }
            int i3 = (int) j2;
            if (skipBytes(i3) != i3) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public int available() throws IOException {
            return this.f5076a.available();
        }

        public int read() throws IOException {
            this.f5079d++;
            return this.f5076a.read();
        }

        public boolean readBoolean() throws IOException {
            this.f5079d++;
            return this.f5076a.readBoolean();
        }

        public byte readByte() throws IOException {
            int i2 = this.f5079d + 1;
            this.f5079d = i2;
            if (i2 <= this.f5078c) {
                int read = this.f5076a.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public char readChar() throws IOException {
            this.f5079d += 2;
            return this.f5076a.readChar();
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = this.f5079d + i3;
            this.f5079d = i4;
            if (i4 > this.f5078c) {
                throw new EOFException();
            } else if (this.f5076a.read(bArr, i2, i3) != i3) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public int readInt() throws IOException {
            int i2 = this.f5079d + 4;
            this.f5079d = i2;
            if (i2 <= this.f5078c) {
                int read = this.f5076a.read();
                int read2 = this.f5076a.read();
                int read3 = this.f5076a.read();
                int read4 = this.f5076a.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.f5077b;
                    if (byteOrder == f5074e) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == f5075f) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    StringBuilder a2 = e.a.a.a.a.a("Invalid byte order: ");
                    a2.append(this.f5077b);
                    throw new IOException(a2.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        public long readLong() throws IOException {
            int i2 = this.f5079d + 8;
            this.f5079d = i2;
            if (i2 <= this.f5078c) {
                int read = this.f5076a.read();
                int read2 = this.f5076a.read();
                int read3 = this.f5076a.read();
                int read4 = this.f5076a.read();
                int read5 = this.f5076a.read();
                int read6 = this.f5076a.read();
                int read7 = this.f5076a.read();
                int read8 = this.f5076a.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.f5077b;
                    if (byteOrder == f5074e) {
                        return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                    }
                    if (byteOrder == f5075f) {
                        return (((long) read) << 56) + (((long) read2) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    StringBuilder a2 = e.a.a.a.a.a("Invalid byte order: ");
                    a2.append(this.f5077b);
                    throw new IOException(a2.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            int i2 = this.f5079d + 2;
            this.f5079d = i2;
            if (i2 <= this.f5078c) {
                int read = this.f5076a.read();
                int read2 = this.f5076a.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f5077b;
                    if (byteOrder == f5074e) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == f5075f) {
                        return (short) ((read << 8) + read2);
                    }
                    StringBuilder a2 = e.a.a.a.a.a("Invalid byte order: ");
                    a2.append(this.f5077b);
                    throw new IOException(a2.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public String readUTF() throws IOException {
            this.f5079d += 2;
            return this.f5076a.readUTF();
        }

        public int readUnsignedByte() throws IOException {
            this.f5079d++;
            return this.f5076a.readUnsignedByte();
        }

        public int readUnsignedShort() throws IOException {
            int i2 = this.f5079d + 2;
            this.f5079d = i2;
            if (i2 <= this.f5078c) {
                int read = this.f5076a.read();
                int read2 = this.f5076a.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f5077b;
                    if (byteOrder == f5074e) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == f5075f) {
                        return (read << 8) + read2;
                    }
                    StringBuilder a2 = e.a.a.a.a.a("Invalid byte order: ");
                    a2.append(this.f5077b);
                    throw new IOException(a2.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public int skipBytes(int i2) throws IOException {
            int min = Math.min(i2, this.f5078c - this.f5079d);
            int i3 = 0;
            while (i3 < min) {
                i3 += this.f5076a.skipBytes(min - i3);
            }
            this.f5079d += i3;
            return i3;
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int read = this.f5076a.read(bArr, i2, i3);
            this.f5079d += read;
            return read;
        }

        public void readFully(byte[] bArr) throws IOException {
            int length = this.f5079d + bArr.length;
            this.f5079d = length;
            if (length > this.f5078c) {
                throw new EOFException();
            } else if (this.f5076a.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public long a() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public b(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }
    }

    /* compiled from: ExifInterface */
    public static class c extends FilterOutputStream {

        /* renamed from: a reason: collision with root package name */
        public final OutputStream f5080a;

        /* renamed from: b reason: collision with root package name */
        public ByteOrder f5081b;

        public c(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f5080a = outputStream;
            this.f5081b = byteOrder;
        }

        public void a(short s) throws IOException {
            ByteOrder byteOrder = this.f5081b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f5080a.write((s >>> 0) & 255);
                this.f5080a.write((s >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f5080a.write((s >>> 8) & 255);
                this.f5080a.write((s >>> 0) & 255);
            }
        }

        public void write(byte[] bArr) throws IOException {
            this.f5080a.write(bArr);
        }

        public void writeInt(int i2) throws IOException {
            ByteOrder byteOrder = this.f5081b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f5080a.write((i2 >>> 0) & 255);
                this.f5080a.write((i2 >>> 8) & 255);
                this.f5080a.write((i2 >>> 16) & 255);
                this.f5080a.write((i2 >>> 24) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f5080a.write((i2 >>> 24) & 255);
                this.f5080a.write((i2 >>> 16) & 255);
                this.f5080a.write((i2 >>> 8) & 255);
                this.f5080a.write((i2 >>> 0) & 255);
            }
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            this.f5080a.write(bArr, i2, i3);
        }
    }

    /* compiled from: ExifInterface */
    public static class d {

        /* renamed from: a reason: collision with root package name */
        public final int f5082a;

        /* renamed from: b reason: collision with root package name */
        public final int f5083b;

        /* renamed from: c reason: collision with root package name */
        public final byte[] f5084c;

        public d(int i2, int i3, long j2, byte[] bArr) {
            this.f5082a = i2;
            this.f5083b = i3;
            this.f5084c = bArr;
        }

        public static d a(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.S[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i2 : iArr) {
                wrap.putShort((short) i2);
            }
            return new d(3, iArr.length, wrap.array());
        }

        public int b(ByteOrder byteOrder) {
            Object d2 = d(byteOrder);
            if (d2 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (d2 instanceof String) {
                return Integer.parseInt((String) d2);
            } else {
                String str = "There are more than one component";
                if (d2 instanceof long[]) {
                    long[] jArr = (long[]) d2;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException(str);
                } else if (d2 instanceof int[]) {
                    int[] iArr = (int[]) d2;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException(str);
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String c(ByteOrder byteOrder) {
            Object d2 = d(byteOrder);
            if (d2 == null) {
                return null;
            }
            if (d2 instanceof String) {
                return (String) d2;
            }
            StringBuilder sb = new StringBuilder();
            String str = ",";
            int i2 = 0;
            if (d2 instanceof long[]) {
                long[] jArr = (long[]) d2;
                while (i2 < jArr.length) {
                    sb.append(jArr[i2]);
                    i2++;
                    if (i2 != jArr.length) {
                        sb.append(str);
                    }
                }
                return sb.toString();
            } else if (d2 instanceof int[]) {
                int[] iArr = (int[]) d2;
                while (i2 < iArr.length) {
                    sb.append(iArr[i2]);
                    i2++;
                    if (i2 != iArr.length) {
                        sb.append(str);
                    }
                }
                return sb.toString();
            } else if (d2 instanceof double[]) {
                double[] dArr = (double[]) d2;
                while (i2 < dArr.length) {
                    sb.append(dArr[i2]);
                    i2++;
                    if (i2 != dArr.length) {
                        sb.append(str);
                    }
                }
                return sb.toString();
            } else if (!(d2 instanceof f[])) {
                return null;
            } else {
                f[] fVarArr = (f[]) d2;
                while (i2 < fVarArr.length) {
                    sb.append(fVarArr[i2].f5089a);
                    sb.append('/');
                    sb.append(fVarArr[i2].f5090b);
                    i2++;
                    if (i2 != fVarArr.length) {
                        sb.append(str);
                    }
                }
                return sb.toString();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:164:0x01aa A[SYNTHETIC, Splitter:B:164:0x01aa] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object d(java.nio.ByteOrder r11) {
            /*
                r10 = this;
                java.lang.String r0 = "IOException occurred while closing InputStream"
                java.lang.String r1 = "ExifInterface"
                r2 = 0
                d.m.a.a$b r3 = new d.m.a.a$b     // Catch:{ IOException -> 0x0194, all -> 0x0192 }
                byte[] r4 = r10.f5084c     // Catch:{ IOException -> 0x0194, all -> 0x0192 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x0194, all -> 0x0192 }
                r3.f5077b = r11     // Catch:{ IOException -> 0x0190 }
                int r11 = r10.f5082a     // Catch:{ IOException -> 0x0190 }
                r4 = 1
                r5 = 0
                switch(r11) {
                    case 1: goto L_0x014b;
                    case 2: goto L_0x00fc;
                    case 3: goto L_0x00e2;
                    case 4: goto L_0x00c8;
                    case 5: goto L_0x00a5;
                    case 6: goto L_0x014b;
                    case 7: goto L_0x00fc;
                    case 8: goto L_0x008b;
                    case 9: goto L_0x0071;
                    case 10: goto L_0x004c;
                    case 11: goto L_0x0031;
                    case 12: goto L_0x0017;
                    default: goto L_0x0015;
                }     // Catch:{ IOException -> 0x0190 }
            L_0x0015:
                goto L_0x0187
            L_0x0017:
                int r11 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0190 }
            L_0x001b:
                int r4 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                if (r5 >= r4) goto L_0x0028
                double r6 = r3.readDouble()     // Catch:{ IOException -> 0x0190 }
                r11[r5] = r6     // Catch:{ IOException -> 0x0190 }
                int r5 = r5 + 1
                goto L_0x001b
            L_0x0028:
                r3.close()     // Catch:{ IOException -> 0x002c }
                goto L_0x0030
            L_0x002c:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0030:
                return r11
            L_0x0031:
                int r11 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0190 }
            L_0x0035:
                int r4 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                if (r5 >= r4) goto L_0x0043
                float r4 = r3.readFloat()     // Catch:{ IOException -> 0x0190 }
                double r6 = (double) r4     // Catch:{ IOException -> 0x0190 }
                r11[r5] = r6     // Catch:{ IOException -> 0x0190 }
                int r5 = r5 + 1
                goto L_0x0035
            L_0x0043:
                r3.close()     // Catch:{ IOException -> 0x0047 }
                goto L_0x004b
            L_0x0047:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x004b:
                return r11
            L_0x004c:
                int r11 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                d.m.a.a$f[] r11 = new d.m.a.a.f[r11]     // Catch:{ IOException -> 0x0190 }
            L_0x0050:
                int r4 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                if (r5 >= r4) goto L_0x0068
                int r4 = r3.readInt()     // Catch:{ IOException -> 0x0190 }
                long r6 = (long) r4     // Catch:{ IOException -> 0x0190 }
                int r4 = r3.readInt()     // Catch:{ IOException -> 0x0190 }
                long r8 = (long) r4     // Catch:{ IOException -> 0x0190 }
                d.m.a.a$f r4 = new d.m.a.a$f     // Catch:{ IOException -> 0x0190 }
                r4.<init>(r6, r8)     // Catch:{ IOException -> 0x0190 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0190 }
                int r5 = r5 + 1
                goto L_0x0050
            L_0x0068:
                r3.close()     // Catch:{ IOException -> 0x006c }
                goto L_0x0070
            L_0x006c:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0070:
                return r11
            L_0x0071:
                int r11 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0190 }
            L_0x0075:
                int r4 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                if (r5 >= r4) goto L_0x0082
                int r4 = r3.readInt()     // Catch:{ IOException -> 0x0190 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0190 }
                int r5 = r5 + 1
                goto L_0x0075
            L_0x0082:
                r3.close()     // Catch:{ IOException -> 0x0086 }
                goto L_0x008a
            L_0x0086:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x008a:
                return r11
            L_0x008b:
                int r11 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0190 }
            L_0x008f:
                int r4 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                if (r5 >= r4) goto L_0x009c
                short r4 = r3.readShort()     // Catch:{ IOException -> 0x0190 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0190 }
                int r5 = r5 + 1
                goto L_0x008f
            L_0x009c:
                r3.close()     // Catch:{ IOException -> 0x00a0 }
                goto L_0x00a4
            L_0x00a0:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00a4:
                return r11
            L_0x00a5:
                int r11 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                d.m.a.a$f[] r11 = new d.m.a.a.f[r11]     // Catch:{ IOException -> 0x0190 }
            L_0x00a9:
                int r4 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                if (r5 >= r4) goto L_0x00bf
                long r6 = r3.a()     // Catch:{ IOException -> 0x0190 }
                long r8 = r3.a()     // Catch:{ IOException -> 0x0190 }
                d.m.a.a$f r4 = new d.m.a.a$f     // Catch:{ IOException -> 0x0190 }
                r4.<init>(r6, r8)     // Catch:{ IOException -> 0x0190 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0190 }
                int r5 = r5 + 1
                goto L_0x00a9
            L_0x00bf:
                r3.close()     // Catch:{ IOException -> 0x00c3 }
                goto L_0x00c7
            L_0x00c3:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00c7:
                return r11
            L_0x00c8:
                int r11 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                long[] r11 = new long[r11]     // Catch:{ IOException -> 0x0190 }
            L_0x00cc:
                int r4 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                if (r5 >= r4) goto L_0x00d9
                long r6 = r3.a()     // Catch:{ IOException -> 0x0190 }
                r11[r5] = r6     // Catch:{ IOException -> 0x0190 }
                int r5 = r5 + 1
                goto L_0x00cc
            L_0x00d9:
                r3.close()     // Catch:{ IOException -> 0x00dd }
                goto L_0x00e1
            L_0x00dd:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00e1:
                return r11
            L_0x00e2:
                int r11 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0190 }
            L_0x00e6:
                int r4 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                if (r5 >= r4) goto L_0x00f3
                int r4 = r3.readUnsignedShort()     // Catch:{ IOException -> 0x0190 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0190 }
                int r5 = r5 + 1
                goto L_0x00e6
            L_0x00f3:
                r3.close()     // Catch:{ IOException -> 0x00f7 }
                goto L_0x00fb
            L_0x00f7:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00fb:
                return r11
            L_0x00fc:
                int r11 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                byte[] r6 = d.m.a.a.T     // Catch:{ IOException -> 0x0190 }
                int r6 = r6.length     // Catch:{ IOException -> 0x0190 }
                if (r11 < r6) goto L_0x011d
                r11 = r5
            L_0x0104:
                byte[] r6 = d.m.a.a.T     // Catch:{ IOException -> 0x0190 }
                int r6 = r6.length     // Catch:{ IOException -> 0x0190 }
                if (r11 >= r6) goto L_0x0118
                byte[] r6 = r10.f5084c     // Catch:{ IOException -> 0x0190 }
                byte r6 = r6[r11]     // Catch:{ IOException -> 0x0190 }
                byte[] r7 = d.m.a.a.T     // Catch:{ IOException -> 0x0190 }
                byte r7 = r7[r11]     // Catch:{ IOException -> 0x0190 }
                if (r6 == r7) goto L_0x0115
                r4 = r5
                goto L_0x0118
            L_0x0115:
                int r11 = r11 + 1
                goto L_0x0104
            L_0x0118:
                if (r4 == 0) goto L_0x011d
                byte[] r11 = d.m.a.a.T     // Catch:{ IOException -> 0x0190 }
                int r5 = r11.length     // Catch:{ IOException -> 0x0190 }
            L_0x011d:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0190 }
                r11.<init>()     // Catch:{ IOException -> 0x0190 }
            L_0x0122:
                int r4 = r10.f5083b     // Catch:{ IOException -> 0x0190 }
                if (r5 >= r4) goto L_0x013e
                byte[] r4 = r10.f5084c     // Catch:{ IOException -> 0x0190 }
                byte r4 = r4[r5]     // Catch:{ IOException -> 0x0190 }
                if (r4 != 0) goto L_0x012d
                goto L_0x013e
            L_0x012d:
                r6 = 32
                if (r4 < r6) goto L_0x0136
                char r4 = (char) r4     // Catch:{ IOException -> 0x0190 }
                r11.append(r4)     // Catch:{ IOException -> 0x0190 }
                goto L_0x013b
            L_0x0136:
                r4 = 63
                r11.append(r4)     // Catch:{ IOException -> 0x0190 }
            L_0x013b:
                int r5 = r5 + 1
                goto L_0x0122
            L_0x013e:
                java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x0190 }
                r3.close()     // Catch:{ IOException -> 0x0146 }
                goto L_0x014a
            L_0x0146:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x014a:
                return r11
            L_0x014b:
                byte[] r11 = r10.f5084c     // Catch:{ IOException -> 0x0190 }
                int r11 = r11.length     // Catch:{ IOException -> 0x0190 }
                if (r11 != r4) goto L_0x0175
                byte[] r11 = r10.f5084c     // Catch:{ IOException -> 0x0190 }
                byte r11 = r11[r5]     // Catch:{ IOException -> 0x0190 }
                if (r11 < 0) goto L_0x0175
                byte[] r11 = r10.f5084c     // Catch:{ IOException -> 0x0190 }
                byte r11 = r11[r5]     // Catch:{ IOException -> 0x0190 }
                if (r11 > r4) goto L_0x0175
                java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x0190 }
                char[] r4 = new char[r4]     // Catch:{ IOException -> 0x0190 }
                byte[] r6 = r10.f5084c     // Catch:{ IOException -> 0x0190 }
                byte r6 = r6[r5]     // Catch:{ IOException -> 0x0190 }
                int r6 = r6 + 48
                char r6 = (char) r6     // Catch:{ IOException -> 0x0190 }
                r4[r5] = r6     // Catch:{ IOException -> 0x0190 }
                r11.<init>(r4)     // Catch:{ IOException -> 0x0190 }
                r3.close()     // Catch:{ IOException -> 0x0170 }
                goto L_0x0174
            L_0x0170:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0174:
                return r11
            L_0x0175:
                java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x0190 }
                byte[] r4 = r10.f5084c     // Catch:{ IOException -> 0x0190 }
                java.nio.charset.Charset r5 = d.m.a.a.m0     // Catch:{ IOException -> 0x0190 }
                r11.<init>(r4, r5)     // Catch:{ IOException -> 0x0190 }
                r3.close()     // Catch:{ IOException -> 0x0182 }
                goto L_0x0186
            L_0x0182:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0186:
                return r11
            L_0x0187:
                r3.close()     // Catch:{ IOException -> 0x018b }
                goto L_0x018f
            L_0x018b:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x018f:
                return r2
            L_0x0190:
                r11 = move-exception
                goto L_0x0196
            L_0x0192:
                r11 = move-exception
                goto L_0x01a8
            L_0x0194:
                r11 = move-exception
                r3 = r2
            L_0x0196:
                java.lang.String r4 = "IOException occurred during reading a value"
                android.util.Log.w(r1, r4, r11)     // Catch:{ all -> 0x01a6 }
                if (r3 == 0) goto L_0x01a5
                r3.close()     // Catch:{ IOException -> 0x01a1 }
                goto L_0x01a5
            L_0x01a1:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x01a5:
                return r2
            L_0x01a6:
                r11 = move-exception
                r2 = r3
            L_0x01a8:
                if (r2 == 0) goto L_0x01b2
                r2.close()     // Catch:{ IOException -> 0x01ae }
                goto L_0x01b2
            L_0x01ae:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x01b2:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: d.m.a.a.d.d(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            StringBuilder a2 = e.a.a.a.a.a("(");
            a2.append(a.R[this.f5082a]);
            a2.append(", data length:");
            return e.a.a.a.a.a(a2, this.f5084c.length, ")");
        }

        public d(int i2, int i3, byte[] bArr) {
            this.f5082a = i2;
            this.f5083b = i3;
            this.f5084c = bArr;
        }

        public static d a(int i2, ByteOrder byteOrder) {
            return a(new int[]{i2}, byteOrder);
        }

        public static d a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.S[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j2 : jArr) {
                wrap.putInt((int) j2);
            }
            return new d(4, jArr.length, wrap.array());
        }

        public static d a(long j2, ByteOrder byteOrder) {
            return a(new long[]{j2}, byteOrder);
        }

        public static d a(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(0);
            byte[] bytes = sb.toString().getBytes(a.m0);
            return new d(2, bytes.length, bytes);
        }

        public static d a(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.S[5] * fVarArr.length)]);
            wrap.order(byteOrder);
            for (f fVar : fVarArr) {
                wrap.putInt((int) fVar.f5089a);
                wrap.putInt((int) fVar.f5090b);
            }
            return new d(5, fVarArr.length, wrap.array());
        }

        public double a(ByteOrder byteOrder) {
            Object d2 = d(byteOrder);
            if (d2 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (d2 instanceof String) {
                return Double.parseDouble((String) d2);
            } else {
                String str = "There are more than one component";
                if (d2 instanceof long[]) {
                    long[] jArr = (long[]) d2;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException(str);
                } else if (d2 instanceof int[]) {
                    int[] iArr = (int[]) d2;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException(str);
                } else if (d2 instanceof double[]) {
                    double[] dArr = (double[]) d2;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException(str);
                } else if (d2 instanceof f[]) {
                    f[] fVarArr = (f[]) d2;
                    if (fVarArr.length == 1) {
                        f fVar = fVarArr[0];
                        return ((double) fVar.f5089a) / ((double) fVar.f5090b);
                    }
                    throw new NumberFormatException(str);
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }
    }

    /* compiled from: ExifInterface */
    public static class e {

        /* renamed from: a reason: collision with root package name */
        public final int f5085a;

        /* renamed from: b reason: collision with root package name */
        public final String f5086b;

        /* renamed from: c reason: collision with root package name */
        public final int f5087c;

        /* renamed from: d reason: collision with root package name */
        public final int f5088d;

        public e(String str, int i2, int i3) {
            this.f5086b = str;
            this.f5085a = i2;
            this.f5087c = i3;
            this.f5088d = -1;
        }

        public e(String str, int i2, int i3, int i4) {
            this.f5086b = str;
            this.f5085a = i2;
            this.f5087c = i3;
            this.f5088d = i4;
        }
    }

    /* compiled from: ExifInterface */
    public static class f {

        /* renamed from: a reason: collision with root package name */
        public final long f5089a;

        /* renamed from: b reason: collision with root package name */
        public final long f5090b;

        public f(long j2, long j3) {
            if (j3 == 0) {
                this.f5089a = 0;
                this.f5090b = 1;
                return;
            }
            this.f5089a = j2;
            this.f5090b = j3;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5089a);
            sb.append(BceConfig.BOS_DELIMITER);
            sb.append(this.f5090b);
            return sb.toString();
        }
    }

    static {
        e[] eVarArr;
        Integer valueOf = Integer.valueOf(3);
        Integer valueOf2 = Integer.valueOf(1);
        Integer valueOf3 = Integer.valueOf(2);
        Integer valueOf4 = Integer.valueOf(8);
        Arrays.asList(new Integer[]{valueOf2, Integer.valueOf(6), valueOf, valueOf4});
        Integer valueOf5 = Integer.valueOf(7);
        Integer valueOf6 = Integer.valueOf(5);
        Arrays.asList(new Integer[]{valueOf3, valueOf5, Integer.valueOf(4), valueOf6});
        "XMP ".getBytes(Charset.defaultCharset());
        e[] eVarArr2 = {new e("ColorSpace", 55, 3)};
        d0 = eVarArr2;
        e[] eVarArr3 = U;
        e0 = new e[][]{eVarArr3, V, W, X, Y, eVarArr3, a0, b0, c0, eVarArr2};
        e[][] eVarArr4 = e0;
        i0 = new HashMap[eVarArr4.length];
        j0 = new HashMap[eVarArr4.length];
        Charset forName = Charset.forName("US-ASCII");
        m0 = forName;
        n0 = "Exif\u0000\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        Q = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i2 = 0; i2 < e0.length; i2++) {
            i0[i2] = new HashMap<>();
            j0[i2] = new HashMap<>();
            for (e eVar : e0[i2]) {
                i0[i2].put(Integer.valueOf(eVar.f5085a), eVar);
                j0[i2].put(eVar.f5086b, eVar);
            }
        }
        l0.put(Integer.valueOf(f0[0].f5085a), valueOf6);
        l0.put(Integer.valueOf(f0[1].f5085a), valueOf2);
        l0.put(Integer.valueOf(f0[2].f5085a), valueOf3);
        l0.put(Integer.valueOf(f0[3].f5085a), valueOf);
        l0.put(Integer.valueOf(f0[4].f5085a), valueOf5);
        l0.put(Integer.valueOf(f0[5].f5085a), valueOf4);
        Pattern.compile(".*[1-9].*");
    }

    public a(String str) throws IOException {
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.f5064c = null;
            this.f5062a = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    if (b(fileInputStream2.getFD())) {
                        this.f5063b = fileInputStream2.getFD();
                    } else {
                        this.f5063b = null;
                    }
                    a((InputStream) fileInputStream2);
                    a((Closeable) fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                a((Closeable) fileInputStream);
                throw th;
            }
        } else {
            throw new NullPointerException("filename cannot be null");
        }
    }

    public String a(String str) {
        if (str != null) {
            d b2 = b(str);
            if (b2 != null) {
                if (!k0.contains(str)) {
                    return b2.c(this.f5069h);
                }
                if (str.equals("GPSTimeStamp")) {
                    int i2 = b2.f5082a;
                    String str2 = "ExifInterface";
                    if (i2 == 5 || i2 == 10) {
                        f[] fVarArr = (f[]) b2.d(this.f5069h);
                        if (fVarArr == null || fVarArr.length != 3) {
                            StringBuilder a2 = e.a.a.a.a.a("Invalid GPS Timestamp array. array=");
                            a2.append(Arrays.toString(fVarArr));
                            Log.w(str2, a2.toString());
                            return null;
                        }
                        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) fVarArr[0].f5089a) / ((float) fVarArr[0].f5090b))), Integer.valueOf((int) (((float) fVarArr[1].f5089a) / ((float) fVarArr[1].f5090b))), Integer.valueOf((int) (((float) fVarArr[2].f5089a) / ((float) fVarArr[2].f5090b)))});
                    }
                    StringBuilder a3 = e.a.a.a.a.a("GPS Timestamp format is not rational. format=");
                    a3.append(b2.f5082a);
                    Log.w(str2, a3.toString());
                    return null;
                }
                try {
                    return Double.toString(b2.a(this.f5069h));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public final d b(String str) {
        if (str != null) {
            if ("ISOSpeedRatings".equals(str)) {
                if (v) {
                    Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str = "PhotographicSensitivity";
            }
            for (int i2 = 0; i2 < e0.length; i2++) {
                d dVar = (d) this.f5067f[i2].get(str);
                if (dVar != null) {
                    return dVar;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public final void c(String str) {
        for (int i2 = 0; i2 < e0.length; i2++) {
            this.f5067f[i2].remove(str);
        }
    }

    public final void d(b bVar) throws IOException {
        bVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        bVar.read(bArr);
        bVar.skipBytes(4);
        bVar.read(bArr2);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        a(bVar, i2, 5);
        bVar.a((long) i3);
        bVar.f5077b = ByteOrder.BIG_ENDIAN;
        int readInt = bVar.readInt();
        String str = "ExifInterface";
        if (v) {
            e.a.a.a.a.b("numberOfDirectoryEntry: ", readInt, str);
        }
        for (int i4 = 0; i4 < readInt; i4++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == Z.f5085a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                d a2 = d.a((int) readShort, this.f5069h);
                d a3 = d.a((int) readShort2, this.f5069h);
                this.f5067f[0].put("ImageLength", a2);
                this.f5067f[0].put("ImageWidth", a3);
                if (v) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Updated to length: ");
                    sb.append(readShort);
                    sb.append(", width: ");
                    sb.append(readShort2);
                    Log.d(str, sb.toString());
                }
                return;
            }
            bVar.skipBytes(readUnsignedShort2);
        }
    }

    public final void e(b bVar) throws IOException {
        a(bVar, bVar.available());
        b(bVar, 0);
        c(bVar, 0);
        c(bVar, 5);
        c(bVar, 4);
        e();
        if (this.f5065d == 8) {
            d dVar = (d) this.f5067f[1].get("MakerNote");
            if (dVar != null) {
                b bVar2 = new b(dVar.f5084c);
                bVar2.f5077b = this.f5069h;
                bVar2.a(6);
                b(bVar2, 9);
                String str = "ColorSpace";
                d dVar2 = (d) this.f5067f[9].get(str);
                if (dVar2 != null) {
                    this.f5067f[1].put(str, dVar2);
                }
            }
        }
    }

    public final void f(b bVar) throws IOException {
        e(bVar);
        if (((d) this.f5067f[0].get("JpgFromRaw")) != null) {
            a(bVar, this.s, 5);
        }
        d dVar = (d) this.f5067f[0].get("ISO");
        String str = "PhotographicSensitivity";
        d dVar2 = (d) this.f5067f[1].get(str);
        if (dVar != null && dVar2 == null) {
            this.f5067f[1].put(str, dVar);
        }
    }

    public final void g(b bVar) throws IOException {
        bVar.skipBytes(n0.length);
        byte[] bArr = new byte[bVar.available()];
        bVar.readFully(bArr);
        this.o = n0.length;
        a(bArr, 0);
    }

    public final void h(b bVar) throws IOException {
        if (v) {
            StringBuilder sb = new StringBuilder();
            sb.append("getWebpAttributes starting with: ");
            sb.append(bVar);
            Log.d("ExifInterface", sb.toString());
        }
        bVar.f5077b = ByteOrder.LITTLE_ENDIAN;
        bVar.skipBytes(I.length);
        int readInt = bVar.readInt() + 8;
        int skipBytes = bVar.skipBytes(J.length) + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (bVar.read(bArr) == 4) {
                    int i2 = skipBytes + 4;
                    int readInt2 = bVar.readInt();
                    int i3 = i2 + 4;
                    if (Arrays.equals(K, bArr)) {
                        byte[] bArr2 = new byte[readInt2];
                        if (bVar.read(bArr2) == readInt2) {
                            this.o = i3;
                            a(bArr2, 0);
                            this.o = i3;
                            return;
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Failed to read given length for given PNG chunk type: ");
                        sb2.append(a(bArr));
                        throw new IOException(sb2.toString());
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    int i4 = i3 + readInt2;
                    if (i4 != readInt) {
                        String str = "Encountered WebP file with invalid chunk size";
                        if (i4 <= readInt) {
                            int skipBytes2 = bVar.skipBytes(readInt2);
                            if (skipBytes2 == readInt2) {
                                skipBytes = i3 + skipBytes2;
                            } else {
                                throw new IOException(str);
                            }
                        } else {
                            throw new IOException(str);
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final ByteOrder i(b bVar) throws IOException {
        short readShort = bVar.readShort();
        String str = "ExifInterface";
        if (readShort == 18761) {
            if (v) {
                Log.d(str, "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            if (v) {
                Log.d(str, "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        } else {
            StringBuilder a2 = e.a.a.a.a.a("Invalid byte order: ");
            a2.append(Integer.toHexString(readShort));
            throw new IOException(a2.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0067, code lost:
        if (java.util.Arrays.equals(r3, x) != false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0071, code lost:
        if (java.util.Arrays.equals(r3, w) != false) goto L_0x0048;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j(d.m.a.a.b r19) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            java.util.HashMap<java.lang.String, d.m.a.a$d>[] r2 = r0.f5067f
            r3 = 4
            r2 = r2[r3]
            java.lang.String r3 = "Compression"
            java.lang.Object r3 = r2.get(r3)
            d.m.a.a$d r3 = (d.m.a.a.d) r3
            r4 = 6
            if (r3 == 0) goto L_0x0127
            java.nio.ByteOrder r5 = r0.f5069h
            int r3 = r3.b(r5)
            r0.n = r3
            r5 = 1
            if (r3 == r5) goto L_0x002b
            if (r3 == r4) goto L_0x0026
            r6 = 7
            if (r3 == r6) goto L_0x002b
            goto L_0x012c
        L_0x0026:
            r0.a(r1, r2)
            goto L_0x012c
        L_0x002b:
            java.lang.String r3 = "BitsPerSample"
            java.lang.Object r3 = r2.get(r3)
            d.m.a.a$d r3 = (d.m.a.a.d) r3
            java.lang.String r6 = "ExifInterface"
            r7 = 0
            if (r3 == 0) goto L_0x0074
            java.nio.ByteOrder r8 = r0.f5069h
            java.lang.Object r3 = r3.d(r8)
            int[] r3 = (int[]) r3
            int[] r8 = w
            boolean r8 = java.util.Arrays.equals(r8, r3)
            if (r8 == 0) goto L_0x004a
        L_0x0048:
            r3 = r5
            goto L_0x007e
        L_0x004a:
            int r8 = r0.f5065d
            r9 = 3
            if (r8 != r9) goto L_0x0074
            java.lang.String r8 = "PhotometricInterpretation"
            java.lang.Object r8 = r2.get(r8)
            d.m.a.a$d r8 = (d.m.a.a.d) r8
            if (r8 == 0) goto L_0x0074
            java.nio.ByteOrder r9 = r0.f5069h
            int r8 = r8.b(r9)
            if (r8 != r5) goto L_0x0069
            int[] r9 = x
            boolean r9 = java.util.Arrays.equals(r3, r9)
            if (r9 != 0) goto L_0x0048
        L_0x0069:
            if (r8 != r4) goto L_0x0074
            int[] r4 = w
            boolean r3 = java.util.Arrays.equals(r3, r4)
            if (r3 == 0) goto L_0x0074
            goto L_0x0048
        L_0x0074:
            boolean r3 = v
            if (r3 == 0) goto L_0x007d
            java.lang.String r3 = "Unsupported data type value"
            android.util.Log.d(r6, r3)
        L_0x007d:
            r3 = r7
        L_0x007e:
            if (r3 == 0) goto L_0x012c
            java.lang.String r3 = "StripOffsets"
            java.lang.Object r3 = r2.get(r3)
            d.m.a.a$d r3 = (d.m.a.a.d) r3
            java.lang.String r4 = "StripByteCounts"
            java.lang.Object r2 = r2.get(r4)
            d.m.a.a$d r2 = (d.m.a.a.d) r2
            if (r3 == 0) goto L_0x012c
            if (r2 == 0) goto L_0x012c
            java.nio.ByteOrder r4 = r0.f5069h
            java.lang.Object r3 = r3.d(r4)
            long[] r3 = a(r3)
            java.nio.ByteOrder r4 = r0.f5069h
            java.lang.Object r2 = r2.d(r4)
            long[] r2 = a(r2)
            if (r3 == 0) goto L_0x0121
            int r4 = r3.length
            if (r4 != 0) goto L_0x00af
            goto L_0x0121
        L_0x00af:
            if (r2 == 0) goto L_0x011b
            int r4 = r2.length
            if (r4 != 0) goto L_0x00b5
            goto L_0x011b
        L_0x00b5:
            int r4 = r3.length
            int r8 = r2.length
            if (r4 == r8) goto L_0x00c0
            java.lang.String r1 = "stripOffsets and stripByteCounts should have same length."
            android.util.Log.w(r6, r1)
            goto L_0x012c
        L_0x00c0:
            r8 = 0
            int r4 = r2.length
            r10 = r7
        L_0x00c4:
            if (r10 >= r4) goto L_0x00cc
            r11 = r2[r10]
            long r8 = r8 + r11
            int r10 = r10 + 1
            goto L_0x00c4
        L_0x00cc:
            int r4 = (int) r8
            byte[] r8 = new byte[r4]
            r0.f5071j = r5
            r0.f5070i = r5
            r9 = r7
            r10 = r9
            r11 = r10
        L_0x00d6:
            int r12 = r3.length
            if (r9 >= r12) goto L_0x010a
            r12 = r3[r9]
            int r12 = (int) r12
            r13 = r2[r9]
            int r13 = (int) r13
            int r14 = r3.length
            int r14 = r14 - r5
            if (r9 >= r14) goto L_0x00f0
            int r14 = r12 + r13
            long r14 = (long) r14
            int r16 = r9 + 1
            r16 = r3[r16]
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 == 0) goto L_0x00f0
            r0.f5071j = r7
        L_0x00f0:
            int r12 = r12 - r10
            if (r12 >= 0) goto L_0x00f8
            java.lang.String r14 = "Invalid strip offset value"
            android.util.Log.d(r6, r14)
        L_0x00f8:
            long r14 = (long) r12
            r1.a(r14)
            int r10 = r10 + r12
            byte[] r12 = new byte[r13]
            r1.read(r12)
            int r10 = r10 + r13
            java.lang.System.arraycopy(r12, r7, r8, r11, r13)
            int r11 = r11 + r13
            int r9 = r9 + 1
            goto L_0x00d6
        L_0x010a:
            r0.m = r8
            boolean r1 = r0.f5071j
            if (r1 == 0) goto L_0x012c
            r1 = r3[r7]
            int r1 = (int) r1
            int r2 = r0.o
            int r1 = r1 + r2
            r0.k = r1
            r0.l = r4
            goto L_0x012c
        L_0x011b:
            java.lang.String r1 = "stripByteCounts should not be null or have zero length."
            android.util.Log.w(r6, r1)
            goto L_0x012c
        L_0x0121:
            java.lang.String r1 = "stripOffsets should not be null or have zero length."
            android.util.Log.w(r6, r1)
            goto L_0x012c
        L_0x0127:
            r0.n = r4
            r0.a(r1, r2)
        L_0x012c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.m.a.a.j(d.m.a.a$b):void");
    }

    public final void c() {
        for (int i2 = 0; i2 < this.f5067f.length; i2++) {
            StringBuilder a2 = e.a.a.a.a.a("The size of tag group[", i2, "]: ");
            a2.append(this.f5067f[i2].size());
            String str = "ExifInterface";
            Log.d(str, a2.toString());
            for (Entry entry : this.f5067f[i2].entrySet()) {
                d dVar = (d) entry.getValue();
                StringBuilder a3 = e.a.a.a.a.a("tagName: ");
                a3.append((String) entry.getKey());
                a3.append(", tagType: ");
                a3.append(dVar.toString());
                a3.append(", tagValue: '");
                a3.append(dVar.c(this.f5069h));
                a3.append("'");
                Log.d(str, a3.toString());
            }
        }
    }

    public static boolean b(FileDescriptor fileDescriptor) {
        try {
            Os.lseek(fileDescriptor, 0, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (v) {
                Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
            }
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0062 A[SYNTHETIC, Splitter:B:39:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0097 A[Catch:{ Exception -> 0x0095 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] b() {
        /*
            r9 = this;
            java.lang.String r0 = "ExifInterface"
            boolean r1 = r9.f5070i
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            byte[] r1 = r9.m
            if (r1 == 0) goto L_0x000d
            return r1
        L_0x000d:
            android.content.res.AssetManager$AssetInputStream r1 = r9.f5064c     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            if (r1 == 0) goto L_0x0030
            android.content.res.AssetManager$AssetInputStream r1 = r9.f5064c     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            boolean r3 = r1.markSupported()     // Catch:{ Exception -> 0x002b, all -> 0x0027 }
            if (r3 == 0) goto L_0x001e
            r1.reset()     // Catch:{ Exception -> 0x002b, all -> 0x0027 }
        L_0x001c:
            r3 = r2
            goto L_0x0060
        L_0x001e:
            java.lang.String r3 = "Cannot read thumbnail from inputstream without mark/reset support"
            android.util.Log.d(r0, r3)     // Catch:{ Exception -> 0x002b, all -> 0x0027 }
            a(r1)
            return r2
        L_0x0027:
            r0 = move-exception
            r3 = r2
            goto L_0x00b3
        L_0x002b:
            r3 = move-exception
            r4 = r3
            r3 = r2
            goto L_0x00a4
        L_0x0030:
            java.lang.String r1 = r9.f5062a     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            if (r1 == 0) goto L_0x003c
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            java.lang.String r3 = r9.f5062a     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            r1.<init>(r3)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            goto L_0x001c
        L_0x003c:
            java.io.FileDescriptor r1 = r9.f5063b     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            if (r1 == 0) goto L_0x005e
            java.io.FileDescriptor r1 = r9.f5063b     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            java.io.FileDescriptor r1 = android.system.Os.dup(r1)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            r3 = 0
            int r5 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            android.system.Os.lseek(r1, r3, r5)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r8 = r3
            r3 = r1
            r1 = r8
            goto L_0x0060
        L_0x0056:
            r0 = move-exception
            r3 = r1
            goto L_0x00b4
        L_0x0059:
            r3 = move-exception
            r4 = r3
            r3 = r1
            r1 = r2
            goto L_0x00a4
        L_0x005e:
            r1 = r2
            r3 = r1
        L_0x0060:
            if (r1 == 0) goto L_0x0097
            int r4 = r9.k     // Catch:{ Exception -> 0x0095 }
            long r4 = (long) r4     // Catch:{ Exception -> 0x0095 }
            long r4 = r1.skip(r4)     // Catch:{ Exception -> 0x0095 }
            int r6 = r9.k     // Catch:{ Exception -> 0x0095 }
            long r6 = (long) r6
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            java.lang.String r5 = "Corrupted image"
            if (r4 != 0) goto L_0x008f
            int r4 = r9.l     // Catch:{ Exception -> 0x0095 }
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0095 }
            int r6 = r1.read(r4)     // Catch:{ Exception -> 0x0095 }
            int r7 = r9.l     // Catch:{ Exception -> 0x0095 }
            if (r6 != r7) goto L_0x0089
            r9.m = r4     // Catch:{ Exception -> 0x0095 }
            a(r1)
            if (r3 == 0) goto L_0x0088
            a(r3)
        L_0x0088:
            return r4
        L_0x0089:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ Exception -> 0x0095 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0095 }
            throw r4     // Catch:{ Exception -> 0x0095 }
        L_0x008f:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ Exception -> 0x0095 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0095 }
            throw r4     // Catch:{ Exception -> 0x0095 }
        L_0x0095:
            r4 = move-exception
            goto L_0x00a4
        L_0x0097:
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException     // Catch:{ Exception -> 0x0095 }
            r4.<init>()     // Catch:{ Exception -> 0x0095 }
            throw r4     // Catch:{ Exception -> 0x0095 }
        L_0x009d:
            r0 = move-exception
            r3 = r2
            goto L_0x00b4
        L_0x00a0:
            r3 = move-exception
            r1 = r2
            r4 = r3
            r3 = r1
        L_0x00a4:
            java.lang.String r5 = "Encountered exception while getting thumbnail"
            android.util.Log.d(r0, r5, r4)     // Catch:{ all -> 0x00b2 }
            a(r1)
            if (r3 == 0) goto L_0x00b1
            a(r3)
        L_0x00b1:
            return r2
        L_0x00b2:
            r0 = move-exception
        L_0x00b3:
            r2 = r1
        L_0x00b4:
            a(r2)
            if (r3 == 0) goto L_0x00bc
            a(r3)
        L_0x00bc:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.m.a.a.b():byte[]");
    }

    public final void c(b bVar) throws IOException {
        if (v) {
            StringBuilder sb = new StringBuilder();
            sb.append("getPngAttributes starting with: ");
            sb.append(bVar);
            Log.d("ExifInterface", sb.toString());
        }
        bVar.f5077b = ByteOrder.BIG_ENDIAN;
        bVar.skipBytes(E.length);
        int length = E.length + 0;
        while (true) {
            try {
                int readInt = bVar.readInt();
                int i2 = length + 4;
                byte[] bArr = new byte[4];
                if (bVar.read(bArr) == 4) {
                    int i3 = i2 + 4;
                    if (i3 == 16) {
                        if (!Arrays.equals(bArr, G)) {
                            throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                        }
                    }
                    if (!Arrays.equals(bArr, H)) {
                        if (Arrays.equals(bArr, F)) {
                            byte[] bArr2 = new byte[readInt];
                            if (bVar.read(bArr2) == readInt) {
                                int readInt2 = bVar.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr);
                                crc32.update(bArr2);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.o = i3;
                                    a(bArr2, 0);
                                    e();
                                    return;
                                }
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: ");
                                sb2.append(readInt2);
                                sb2.append(", calculated CRC value: ");
                                sb2.append(crc32.getValue());
                                throw new IOException(sb2.toString());
                            }
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Failed to read given length for given PNG chunk type: ");
                            sb3.append(a(bArr));
                            throw new IOException(sb3.toString());
                        }
                        int i4 = readInt + 4;
                        bVar.skipBytes(i4);
                        length = i3 + i4;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public a(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            this.f5062a = null;
            if (inputStream instanceof AssetInputStream) {
                this.f5064c = (AssetInputStream) inputStream;
                this.f5063b = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (b(fileInputStream.getFD())) {
                        this.f5064c = null;
                        this.f5063b = fileInputStream.getFD();
                    }
                }
                this.f5064c = null;
                this.f5063b = null;
            }
            a(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }

    public int a(String str, int i2) {
        if (str != null) {
            d b2 = b(str);
            if (b2 == null) {
                return i2;
            }
            try {
                return b2.b(this.f5069h);
            } catch (NumberFormatException unused) {
                return i2;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    public final void e() throws IOException {
        a(0, 5);
        a(0, 4);
        a(5, 4);
        d dVar = (d) this.f5067f[1].get("PixelXDimension");
        d dVar2 = (d) this.f5067f[1].get("PixelYDimension");
        if (!(dVar == null || dVar2 == null)) {
            this.f5067f[0].put("ImageWidth", dVar);
            this.f5067f[0].put("ImageLength", dVar2);
        }
        if (this.f5067f[4].isEmpty() && a((HashMap) this.f5067f[5])) {
            HashMap<String, d>[] hashMapArr = this.f5067f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!a((HashMap) this.f5067f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
    }

    public void a(String str, String str2) {
        int i2;
        d dVar;
        int i3;
        String str3;
        String str4 = str;
        String str5 = str2;
        if (str4 != null) {
            String str6 = "ExifInterface";
            if ("ISOSpeedRatings".equals(str4)) {
                if (v) {
                    Log.d(str6, "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str4 = "PhotographicSensitivity";
            }
            int i4 = 2;
            String str7 = BceConfig.BOS_DELIMITER;
            int i5 = 1;
            if (str5 != null && k0.contains(str4)) {
                String str8 = " : ";
                String str9 = "Invalid value for ";
                if (str4.equals("GPSTimeStamp")) {
                    Matcher matcher = p0.matcher(str5);
                    if (!matcher.find()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str9);
                        sb.append(str4);
                        sb.append(str8);
                        sb.append(str5);
                        Log.w(str6, sb.toString());
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(Integer.parseInt(matcher.group(1)));
                    String str10 = "/1,";
                    sb2.append(str10);
                    sb2.append(Integer.parseInt(matcher.group(2)));
                    sb2.append(str10);
                    sb2.append(Integer.parseInt(matcher.group(3)));
                    sb2.append("/1");
                    str5 = sb2.toString();
                } else {
                    try {
                        long parseDouble = (long) (Double.parseDouble(str2) * 10000.0d);
                        long j2 = FragmentStateAdapter.GRACE_WINDOW_TIME_MS;
                        if (FragmentStateAdapter.GRACE_WINDOW_TIME_MS == 0) {
                            j2 = 1;
                            parseDouble = 0;
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(parseDouble);
                        sb3.append(str7);
                        sb3.append(j2);
                        str5 = sb3.toString();
                    } catch (NumberFormatException unused) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str9);
                        sb4.append(str4);
                        sb4.append(str8);
                        sb4.append(str5);
                        Log.w(str6, sb4.toString());
                        return;
                    }
                }
            }
            int i6 = 0;
            int i7 = 0;
            while (i6 < e0.length) {
                if (i6 != 4 || this.f5070i) {
                    e eVar = (e) j0[i6].get(str4);
                    if (eVar != null) {
                        if (str5 == null) {
                            this.f5067f[i6].remove(str4);
                        } else {
                            Pair d2 = d(str5);
                            int i8 = -1;
                            if (eVar.f5087c == ((Integer) d2.first).intValue() || eVar.f5087c == ((Integer) d2.second).intValue()) {
                                i2 = eVar.f5087c;
                            } else {
                                int i9 = eVar.f5088d;
                                if (i9 == -1 || !(i9 == ((Integer) d2.first).intValue() || eVar.f5088d == ((Integer) d2.second).intValue())) {
                                    int i10 = eVar.f5087c;
                                    if (i10 == i5 || i10 == 7 || i10 == i4) {
                                        i2 = eVar.f5087c;
                                    } else if (v) {
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("Given tag (");
                                        sb5.append(str4);
                                        sb5.append(") value didn't match with one of expected formats: ");
                                        sb5.append(R[eVar.f5087c]);
                                        String str11 = "";
                                        String str12 = ", ";
                                        if (eVar.f5088d == -1) {
                                            str3 = str11;
                                        } else {
                                            StringBuilder a2 = e.a.a.a.a.a(str12);
                                            a2.append(R[eVar.f5088d]);
                                            str3 = a2.toString();
                                        }
                                        sb5.append(str3);
                                        sb5.append(" (guess: ");
                                        sb5.append(R[((Integer) d2.first).intValue()]);
                                        if (((Integer) d2.second).intValue() != -1) {
                                            StringBuilder a3 = e.a.a.a.a.a(str12);
                                            a3.append(R[((Integer) d2.second).intValue()]);
                                            str11 = a3.toString();
                                        }
                                        sb5.append(str11);
                                        sb5.append(")");
                                        Log.d(str6, sb5.toString());
                                    }
                                } else {
                                    i2 = eVar.f5088d;
                                }
                            }
                            String str13 = ",";
                            switch (i2) {
                                case 1:
                                    HashMap<String, d> hashMap = this.f5067f[i6];
                                    if (str5.length() == 1) {
                                        i3 = 0;
                                        if (str5.charAt(0) >= '0' && str5.charAt(0) <= '1') {
                                            dVar = new d(1, 1, new byte[]{(byte) (str5.charAt(0) - '0')});
                                            hashMap.put(str4, dVar);
                                            i7 = i3;
                                            i5 = 1;
                                            continue;
                                        }
                                    } else {
                                        i3 = 0;
                                    }
                                    byte[] bytes = str5.getBytes(m0);
                                    dVar = new d(1, bytes.length, bytes);
                                    hashMap.put(str4, dVar);
                                    i7 = i3;
                                    i5 = 1;
                                    continue;
                                case 2:
                                case 7:
                                    this.f5067f[i6].put(str4, d.a(str5));
                                    break;
                                case 3:
                                    String[] split = str5.split(str13, -1);
                                    int[] iArr = new int[split.length];
                                    for (int i11 = 0; i11 < split.length; i11++) {
                                        iArr[i11] = Integer.parseInt(split[i11]);
                                    }
                                    this.f5067f[i6].put(str4, d.a(iArr, this.f5069h));
                                    break;
                                case 4:
                                    String[] split2 = str5.split(str13, -1);
                                    long[] jArr = new long[split2.length];
                                    for (int i12 = 0; i12 < split2.length; i12++) {
                                        jArr[i12] = Long.parseLong(split2[i12]);
                                    }
                                    this.f5067f[i6].put(str4, d.a(jArr, this.f5069h));
                                    break;
                                case 5:
                                    String[] split3 = str5.split(str13, -1);
                                    f[] fVarArr = new f[split3.length];
                                    int i13 = 0;
                                    while (i13 < split3.length) {
                                        String[] split4 = split3[i13].split(str7, i8);
                                        fVarArr[i13] = new f((long) Double.parseDouble(split4[0]), (long) Double.parseDouble(split4[1]));
                                        i13++;
                                        i8 = -1;
                                    }
                                    this.f5067f[i6].put(str4, d.a(fVarArr, this.f5069h));
                                    break;
                                case 9:
                                    String[] split5 = str5.split(str13, -1);
                                    int length = split5.length;
                                    int[] iArr2 = new int[length];
                                    for (int i14 = 0; i14 < split5.length; i14++) {
                                        iArr2[i14] = Integer.parseInt(split5[i14]);
                                    }
                                    HashMap<String, d> hashMap2 = this.f5067f[i6];
                                    ByteOrder byteOrder = this.f5069h;
                                    ByteBuffer wrap = ByteBuffer.wrap(new byte[(S[9] * length)]);
                                    wrap.order(byteOrder);
                                    for (int i15 = 0; i15 < length; i15++) {
                                        wrap.putInt(iArr2[i15]);
                                    }
                                    hashMap2.put(str4, new d(9, length, wrap.array()));
                                    break;
                                case 10:
                                    String[] split6 = str5.split(str13, -1);
                                    int length2 = split6.length;
                                    f[] fVarArr2 = new f[length2];
                                    int i16 = i7;
                                    while (i7 < split6.length) {
                                        String[] split7 = split6[i7].split(str7, i8);
                                        fVarArr2[i7] = new f((long) Double.parseDouble(split7[i16]), (long) Double.parseDouble(split7[i5]));
                                        i7++;
                                        i5 = 1;
                                        i16 = 0;
                                        i8 = -1;
                                    }
                                    HashMap<String, d> hashMap3 = this.f5067f[i6];
                                    ByteOrder byteOrder2 = this.f5069h;
                                    ByteBuffer wrap2 = ByteBuffer.wrap(new byte[(S[10] * length2)]);
                                    wrap2.order(byteOrder2);
                                    for (int i17 = 0; i17 < length2; i17++) {
                                        f fVar = fVarArr2[i17];
                                        wrap2.putInt((int) fVar.f5089a);
                                        wrap2.putInt((int) fVar.f5090b);
                                    }
                                    hashMap3.put(str4, new d(10, length2, wrap2.array()));
                                    break;
                                case 12:
                                    String[] split8 = str5.split(str13, -1);
                                    int length3 = split8.length;
                                    double[] dArr = new double[length3];
                                    for (int i18 = i7; i18 < split8.length; i18++) {
                                        dArr[i18] = Double.parseDouble(split8[i18]);
                                    }
                                    HashMap<String, d> hashMap4 = this.f5067f[i6];
                                    ByteOrder byteOrder3 = this.f5069h;
                                    ByteBuffer wrap3 = ByteBuffer.wrap(new byte[(S[12] * length3)]);
                                    wrap3.order(byteOrder3);
                                    for (int i19 = i7; i19 < length3; i19++) {
                                        wrap3.putDouble(dArr[i19]);
                                    }
                                    hashMap4.put(str4, new d(12, length3, wrap3.array()));
                                    continue;
                                default:
                                    if (v) {
                                        e.a.a.a.a.b("Data format isn't one of expected formats: ", i2, str6);
                                        break;
                                    } else {
                                        continue;
                                    }
                            }
                            i5 = 1;
                            i7 = 0;
                        }
                    }
                }
                i6++;
                i4 = 2;
            }
            return;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:68|69|70) */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        java.lang.Double.parseDouble(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015c, code lost:
        return new android.util.Pair<>(java.lang.Integer.valueOf(12), r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0162, code lost:
        return new android.util.Pair<>(r5, r7);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x014e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> d(java.lang.String r12) {
        /*
            java.lang.String r0 = ","
            boolean r1 = r12.contains(r0)
            r2 = 0
            r3 = 1
            r4 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6 = -1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            if (r1 == 0) goto L_0x00a6
            java.lang.String[] r12 = r12.split(r0, r6)
            r0 = r12[r2]
            android.util.Pair r0 = d(r0)
            java.lang.Object r1 = r0.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 != r4) goto L_0x0029
            return r0
        L_0x0029:
            int r1 = r12.length
            if (r3 >= r1) goto L_0x00a5
            r1 = r12[r3]
            android.util.Pair r1 = d(r1)
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x004d
            java.lang.Object r2 = r1.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r2 = r6
            goto L_0x0055
        L_0x004d:
            java.lang.Object r2 = r0.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
        L_0x0055:
            java.lang.Object r4 = r0.second
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 == r6) goto L_0x0080
            java.lang.Object r4 = r1.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r8 = r0.second
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x0077
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r4 = r0.second
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0080
        L_0x0077:
            java.lang.Object r1 = r0.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x0081
        L_0x0080:
            r1 = r6
        L_0x0081:
            if (r2 != r6) goto L_0x008b
            if (r1 != r6) goto L_0x008b
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        L_0x008b:
            if (r2 != r6) goto L_0x0097
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.<init>(r1, r7)
            goto L_0x00a2
        L_0x0097:
            if (r1 != r6) goto L_0x00a2
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r0.<init>(r1, r7)
        L_0x00a2:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x00a5:
            return r0
        L_0x00a6:
            java.lang.String r0 = "/"
            boolean r1 = r12.contains(r0)
            r8 = 0
            if (r1 == 0) goto L_0x0105
            java.lang.String[] r12 = r12.split(r0, r6)
            int r0 = r12.length
            if (r0 != r4) goto L_0x00ff
            r0 = r12[r2]     // Catch:{ NumberFormatException -> 0x00ff }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            long r0 = (long) r0     // Catch:{ NumberFormatException -> 0x00ff }
            r12 = r12[r3]     // Catch:{ NumberFormatException -> 0x00ff }
            double r2 = java.lang.Double.parseDouble(r12)     // Catch:{ NumberFormatException -> 0x00ff }
            long r2 = (long) r2     // Catch:{ NumberFormatException -> 0x00ff }
            int r12 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r4 = 10
            if (r12 < 0) goto L_0x00f5
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x00d0
            goto L_0x00f5
        L_0x00d0:
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r12 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r0 = 5
            if (r12 > 0) goto L_0x00eb
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 <= 0) goto L_0x00dd
            goto L_0x00eb
        L_0x00dd:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r1, r0)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00eb:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00f5:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00ff:
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        L_0x0105:
            long r0 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ NumberFormatException -> 0x014e }
            long r1 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            r2 = 4
            if (r1 < 0) goto L_0x0130
            long r3 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            r10 = 65535(0xffff, double:3.23786E-319)
            int r1 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r1 > 0) goto L_0x0130
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            r1 = 3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r2)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x0130:
            long r0 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0144
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            r1 = 9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x0144:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x014e:
            java.lang.Double.parseDouble(r12)     // Catch:{ NumberFormatException -> 0x015d }
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x015d }
            r0 = 12
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x015d }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x015d }
            return r12
        L_0x015d:
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: d.m.a.a.d(java.lang.String):android.util.Pair");
    }

    public final void b(b bVar) throws IOException {
        e(bVar);
        d dVar = (d) this.f5067f[1].get("MakerNote");
        if (dVar != null) {
            b bVar2 = new b(dVar.f5084c);
            bVar2.f5077b = this.f5069h;
            byte[] bArr = new byte[C.length];
            bVar2.readFully(bArr);
            bVar2.a(0);
            byte[] bArr2 = new byte[D.length];
            bVar2.readFully(bArr2);
            if (Arrays.equals(bArr, C)) {
                bVar2.a(8);
            } else if (Arrays.equals(bArr2, D)) {
                bVar2.a(12);
            }
            b(bVar2, 6);
            d dVar2 = (d) this.f5067f[7].get("PreviewImageStart");
            d dVar3 = (d) this.f5067f[7].get("PreviewImageLength");
            if (!(dVar2 == null || dVar3 == null)) {
                this.f5067f[5].put("JPEGInterchangeFormat", dVar2);
                this.f5067f[5].put("JPEGInterchangeFormatLength", dVar3);
            }
            d dVar4 = (d) this.f5067f[8].get("AspectFrame");
            if (dVar4 != null) {
                int[] iArr = (int[]) dVar4.d(this.f5069h);
                if (iArr == null || iArr.length != 4) {
                    StringBuilder a2 = e.a.a.a.a.a("Invalid aspect frame values. frame=");
                    a2.append(Arrays.toString(iArr));
                    Log.w("ExifInterface", a2.toString());
                } else if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                    int i2 = (iArr[2] - iArr[0]) + 1;
                    int i3 = (iArr[3] - iArr[1]) + 1;
                    if (i2 < i3) {
                        int i4 = i2 + i3;
                        i3 = i4 - i3;
                        i2 = i4 - i3;
                    }
                    d a3 = d.a(i2, this.f5069h);
                    d a4 = d.a(i3, this.f5069h);
                    this.f5067f[0].put("ImageWidth", a3);
                    this.f5067f[0].put("ImageLength", a4);
                }
            }
        }
    }

    public final void c(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (v) {
            StringBuilder sb = new StringBuilder();
            sb.append("saveWebpAttributes starting with (inputStream: ");
            sb.append(inputStream);
            sb.append(", outputStream: ");
            sb.append(outputStream);
            sb.append(")");
            Log.d("ExifInterface", sb.toString());
        }
        b bVar = new b(inputStream, ByteOrder.LITTLE_ENDIAN);
        c cVar = new c(outputStream, ByteOrder.LITTLE_ENDIAN);
        a((InputStream) bVar, (OutputStream) cVar, I.length);
        bVar.skipBytes(J.length + 4);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                c cVar2 = new c(byteArrayOutputStream2, ByteOrder.LITTLE_ENDIAN);
                if (this.o != 0) {
                    a((InputStream) bVar, (OutputStream) cVar2, ((this.o - ((I.length + 4) + J.length)) - 4) - 4);
                    bVar.skipBytes(4);
                    bVar.skipBytes(bVar.readInt());
                    a(cVar2);
                } else {
                    byte[] bArr = new byte[4];
                    if (bVar.read(bArr) != 4) {
                        throw new IOException("Encountered invalid length while parsing WebP chunk type");
                    } else if (Arrays.equals(bArr, L)) {
                        int readInt = bVar.readInt();
                        boolean z2 = true;
                        byte[] bArr2 = new byte[(readInt % 2 == 1 ? readInt + 1 : readInt)];
                        bVar.read(bArr2);
                        bArr2[0] = (byte) (bArr2[0] | 8);
                        if (((bArr2[0] >> 1) & 1) != 1) {
                            z2 = false;
                        }
                        cVar2.f5080a.write(L);
                        cVar2.writeInt(readInt);
                        cVar2.f5080a.write(bArr2);
                        if (z2) {
                            a(bVar, cVar2, O, null);
                            while (true) {
                                byte[] bArr3 = new byte[4];
                                inputStream.read(bArr3);
                                if (!Arrays.equals(bArr3, P)) {
                                    break;
                                }
                                a(bVar, cVar2, bArr3);
                            }
                            a(cVar2);
                        } else {
                            a(bVar, cVar2, N, M);
                            a(cVar2);
                        }
                    } else if (Arrays.equals(bArr, N) || Arrays.equals(bArr, M)) {
                        throw new IOException("WebP files with only VP8 or VP8L chunks are currently not supported");
                    }
                }
                d(bVar, cVar2);
                cVar.writeInt(byteArrayOutputStream2.size() + J.length);
                cVar.f5080a.write(J);
                byteArrayOutputStream2.writeTo(cVar);
                a((Closeable) byteArrayOutputStream2);
            } catch (Exception e2) {
                e = e2;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    throw new IOException("Failed to save WebP file", e);
                } catch (Throwable th) {
                    th = th;
                    a((Closeable) byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                a((Closeable) byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            throw new IOException("Failed to save WebP file", e);
        }
    }

    public static int d(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i2;
            }
            i2 += read;
            outputStream.write(bArr, 0, read);
        }
    }

    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r9v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r8v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r5v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r7v0, types: [java.io.BufferedInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: type inference failed for: r9v8 */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: type inference failed for: r8v15, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r9v12 */
    /* JADX WARNING: type inference failed for: r9v13 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r9v14 */
    /* JADX WARNING: type inference failed for: r9v15, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: type inference failed for: r5v11 */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r5v13 */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r8v21 */
    /* JADX WARNING: type inference failed for: r9v19 */
    /* JADX WARNING: type inference failed for: r9v20 */
    /* JADX WARNING: type inference failed for: r9v21 */
    /* JADX WARNING: type inference failed for: r9v22 */
    /* JADX WARNING: type inference failed for: r9v23 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r9v1
  assigns: []
  uses: []
  mth insns count: 167
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ca A[Catch:{ Exception -> 0x0122, all -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d2 A[Catch:{ Exception -> 0x0122, all -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f4 A[Catch:{ Exception -> 0x0115, all -> 0x0113 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f8 A[Catch:{ Exception -> 0x0115, all -> 0x0113 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0128 A[Catch:{ all -> 0x0151 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0016  */
    /* JADX WARNING: Unknown variable types count: 16 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() throws java.io.IOException {
        /*
            r11 = this;
            boolean r0 = r11.t
            r1 = 14
            r2 = 13
            r3 = 4
            if (r0 == 0) goto L_0x0013
            int r0 = r11.f5065d
            if (r0 == r3) goto L_0x0011
            if (r0 == r2) goto L_0x0011
            if (r0 != r1) goto L_0x0013
        L_0x0011:
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x0171
            java.io.FileDescriptor r0 = r11.f5063b
            if (r0 != 0) goto L_0x0027
            java.lang.String r0 = r11.f5062a
            if (r0 == 0) goto L_0x001f
            goto L_0x0027
        L_0x001f:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface does not support saving attributes for the current input."
            r0.<init>(r1)
            throw r0
        L_0x0027:
            int r0 = r11.n
            r4 = 6
            r5 = 0
            if (r0 == r4) goto L_0x0033
            r4 = 7
            if (r0 != r4) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r0 = r5
            goto L_0x0037
        L_0x0033:
            byte[] r0 = r11.b()
        L_0x0037:
            r11.m = r0
            java.lang.String r0 = r11.f5062a
            if (r0 == 0) goto L_0x0045
            java.io.File r0 = new java.io.File
            java.lang.String r4 = r11.f5062a
            r0.<init>(r4)
            goto L_0x0046
        L_0x0045:
            r0 = r5
        L_0x0046:
            java.lang.String r4 = r11.f5062a     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            r6 = 0
            if (r4 == 0) goto L_0x0087
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            r8.<init>()     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            java.lang.String r9 = r11.f5062a     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            r8.append(r9)     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            java.lang.String r9 = ".tmp"
            r8.append(r9)     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            r4.<init>(r8)     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            boolean r8 = r0.renameTo(r4)     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            if (r8 == 0) goto L_0x006c
            r8 = r5
            goto L_0x00ba
        L_0x006c:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            r1.<init>()     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            java.lang.String r2 = "Couldn't rename to "
            r1.append(r2)     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            java.lang.String r2 = r4.getAbsolutePath()     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            r1.append(r2)     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            r0.<init>(r1)     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            throw r0     // Catch:{ Exception -> 0x015f, all -> 0x015c }
        L_0x0087:
            java.io.FileDescriptor r4 = r11.f5063b     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            if (r4 == 0) goto L_0x00b8
            java.lang.String r4 = "temp"
            java.lang.String r8 = "tmp"
            java.io.File r4 = java.io.File.createTempFile(r4, r8)     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            java.io.FileDescriptor r8 = r11.f5063b     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            int r9 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            android.system.Os.lseek(r8, r6, r9)     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            java.io.FileDescriptor r9 = r11.f5063b     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            r8.<init>(r9)     // Catch:{ Exception -> 0x015f, all -> 0x015c }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00b3, all -> 0x00ae }
            r9.<init>(r4)     // Catch:{ Exception -> 0x00b3, all -> 0x00ae }
            d(r8, r9)     // Catch:{ Exception -> 0x00ac, all -> 0x00aa }
            goto L_0x00bb
        L_0x00aa:
            r0 = move-exception
            goto L_0x00b0
        L_0x00ac:
            r0 = move-exception
            goto L_0x00b5
        L_0x00ae:
            r0 = move-exception
            r9 = r5
        L_0x00b0:
            r5 = r8
            goto L_0x016a
        L_0x00b3:
            r0 = move-exception
            r9 = r5
        L_0x00b5:
            r5 = r8
            goto L_0x0161
        L_0x00b8:
            r4 = r5
            r8 = r4
        L_0x00ba:
            r9 = r8
        L_0x00bb:
            a(r8)
            a(r9)
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            r8.<init>(r4)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.String r9 = r11.f5062a     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            if (r9 == 0) goto L_0x00d2
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.lang.String r7 = r11.f5062a     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            goto L_0x00e6
        L_0x00d2:
            java.io.FileDescriptor r9 = r11.f5063b     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            if (r9 == 0) goto L_0x00e5
            java.io.FileDescriptor r9 = r11.f5063b     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            int r10 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            android.system.Os.lseek(r9, r6, r10)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.io.FileDescriptor r7 = r11.f5063b     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            goto L_0x00e6
        L_0x00e5:
            r6 = r5
        L_0x00e6:
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0122, all -> 0x011f }
            java.io.BufferedOutputStream r8 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x011b, all -> 0x0117 }
            r8.<init>(r6)     // Catch:{ Exception -> 0x011b, all -> 0x0117 }
            int r6 = r11.f5065d     // Catch:{ Exception -> 0x0115, all -> 0x0113 }
            if (r6 != r3) goto L_0x00f8
            r11.a(r7, r8)     // Catch:{ Exception -> 0x0115, all -> 0x0113 }
            goto L_0x0107
        L_0x00f8:
            int r3 = r11.f5065d     // Catch:{ Exception -> 0x0115, all -> 0x0113 }
            if (r3 != r2) goto L_0x0100
            r11.b(r7, r8)     // Catch:{ Exception -> 0x0115, all -> 0x0113 }
            goto L_0x0107
        L_0x0100:
            int r2 = r11.f5065d     // Catch:{ Exception -> 0x0115, all -> 0x0113 }
            if (r2 != r1) goto L_0x0107
            r11.c(r7, r8)     // Catch:{ Exception -> 0x0115, all -> 0x0113 }
        L_0x0107:
            a(r7)
            a(r8)
            r4.delete()
            r11.m = r5
            return
        L_0x0113:
            r0 = move-exception
            goto L_0x0119
        L_0x0115:
            r1 = move-exception
            goto L_0x011d
        L_0x0117:
            r0 = move-exception
            r8 = r5
        L_0x0119:
            r5 = r7
            goto L_0x0152
        L_0x011b:
            r1 = move-exception
            r8 = r5
        L_0x011d:
            r5 = r7
            goto L_0x0124
        L_0x011f:
            r0 = move-exception
            r8 = r5
            goto L_0x0152
        L_0x0122:
            r1 = move-exception
            r8 = r5
        L_0x0124:
            java.lang.String r2 = r11.f5062a     // Catch:{ all -> 0x0151 }
            if (r2 == 0) goto L_0x0149
            boolean r2 = r4.renameTo(r0)     // Catch:{ all -> 0x0151 }
            if (r2 != 0) goto L_0x0149
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0151 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0151 }
            r2.<init>()     // Catch:{ all -> 0x0151 }
            java.lang.String r3 = "Couldn't restore original file: "
            r2.append(r3)     // Catch:{ all -> 0x0151 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0151 }
            r2.append(r0)     // Catch:{ all -> 0x0151 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0151 }
            r1.<init>(r0)     // Catch:{ all -> 0x0151 }
            throw r1     // Catch:{ all -> 0x0151 }
        L_0x0149:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0151 }
            java.lang.String r2 = "Failed to save new file"
            r0.<init>(r2, r1)     // Catch:{ all -> 0x0151 }
            throw r0     // Catch:{ all -> 0x0151 }
        L_0x0151:
            r0 = move-exception
        L_0x0152:
            a(r5)
            a(r8)
            r4.delete()
            throw r0
        L_0x015c:
            r0 = move-exception
            r9 = r5
            goto L_0x016a
        L_0x015f:
            r0 = move-exception
            r9 = r5
        L_0x0161:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0169 }
            java.lang.String r2 = "Failed to copy original file to temp file"
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0169 }
            throw r1     // Catch:{ all -> 0x0169 }
        L_0x0169:
            r0 = move-exception
        L_0x016a:
            a(r5)
            a(r9)
            throw r0
        L_0x0171:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface only supports saving attributes on JPEG, PNG, or WebP formats."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.m.a.a.d():void");
    }

    public final void b(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (v) {
            StringBuilder sb = new StringBuilder();
            sb.append("savePngAttributes starting with (inputStream: ");
            sb.append(inputStream);
            sb.append(", outputStream: ");
            sb.append(outputStream);
            sb.append(")");
            Log.d("ExifInterface", sb.toString());
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        c cVar = new c(outputStream, ByteOrder.BIG_ENDIAN);
        a((InputStream) dataInputStream, (OutputStream) cVar, E.length);
        int i2 = this.o;
        if (i2 == 0) {
            int readInt = dataInputStream.readInt();
            cVar.writeInt(readInt);
            a((InputStream) dataInputStream, (OutputStream) cVar, readInt + 4 + 4);
        } else {
            a((InputStream) dataInputStream, (OutputStream) cVar, ((i2 - E.length) - 4) - 4);
            dataInputStream.skipBytes(dataInputStream.readInt() + 4 + 4);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                c cVar2 = new c(byteArrayOutputStream2, ByteOrder.BIG_ENDIAN);
                a(cVar2);
                byte[] byteArray = ((ByteArrayOutputStream) cVar2.f5080a).toByteArray();
                cVar.f5080a.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                cVar.writeInt((int) crc32.getValue());
                a((Closeable) byteArrayOutputStream2);
                d(dataInputStream, cVar);
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                a((Closeable) byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            a((Closeable) byteArrayOutputStream);
            throw th;
        }
    }

    public final void c(b bVar, int i2) throws IOException {
        d dVar;
        d dVar2;
        d dVar3 = (d) this.f5067f[i2].get("DefaultCropSize");
        d dVar4 = (d) this.f5067f[i2].get("SensorTopBorder");
        d dVar5 = (d) this.f5067f[i2].get("SensorLeftBorder");
        d dVar6 = (d) this.f5067f[i2].get("SensorBottomBorder");
        d dVar7 = (d) this.f5067f[i2].get("SensorRightBorder");
        String str = "ImageWidth";
        String str2 = "ImageLength";
        if (dVar3 != null) {
            String str3 = "Invalid crop size values. cropSize=";
            String str4 = "ExifInterface";
            if (dVar3.f5082a == 5) {
                f[] fVarArr = (f[]) dVar3.d(this.f5069h);
                if (fVarArr == null || fVarArr.length != 2) {
                    StringBuilder a2 = e.a.a.a.a.a(str3);
                    a2.append(Arrays.toString(fVarArr));
                    Log.w(str4, a2.toString());
                    return;
                }
                f fVar = fVarArr[0];
                f[] fVarArr2 = {fVar};
                dVar2 = d.a(fVarArr2, this.f5069h);
                f fVar2 = fVarArr[1];
                f[] fVarArr3 = {fVar2};
                dVar = d.a(fVarArr3, this.f5069h);
            } else {
                int[] iArr = (int[]) dVar3.d(this.f5069h);
                if (iArr == null || iArr.length != 2) {
                    StringBuilder a3 = e.a.a.a.a.a(str3);
                    a3.append(Arrays.toString(iArr));
                    Log.w(str4, a3.toString());
                    return;
                }
                dVar2 = d.a(iArr[0], this.f5069h);
                dVar = d.a(iArr[1], this.f5069h);
            }
            this.f5067f[i2].put(str, dVar2);
            this.f5067f[i2].put(str2, dVar);
        } else if (dVar4 == null || dVar5 == null || dVar6 == null || dVar7 == null) {
            d dVar8 = (d) this.f5067f[i2].get(str);
            if (((d) this.f5067f[i2].get(str2)) == null || dVar8 == null) {
                d dVar9 = (d) this.f5067f[i2].get("JPEGInterchangeFormat");
                if (dVar9 != null) {
                    a(bVar, dVar9.b(this.f5069h), i2);
                }
            }
        } else {
            int b2 = dVar4.b(this.f5069h);
            int b3 = dVar6.b(this.f5069h);
            int b4 = dVar7.b(this.f5069h);
            int b5 = dVar5.b(this.f5069h);
            if (b3 > b2 && b4 > b5) {
                int i3 = b4 - b5;
                d a4 = d.a(b3 - b2, this.f5069h);
                d a5 = d.a(i3, this.f5069h);
                this.f5067f[i2].put(str2, a4);
                this.f5067f[i2].put(str, a5);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0323, code lost:
        if ("Model".equals(r8.f5086b) != false) goto L_0x0325;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0331, code lost:
        if (r10.c(r0.f5069h).contains("PENTAX") == false) goto L_0x0333;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0339, code lost:
        if (r7.equals(r8.f5086b) == false) goto L_0x034a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0344, code lost:
        if (r10.b(r0.f5069h) != 65535) goto L_0x034a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0346, code lost:
        r0.f5065d = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x034f, code lost:
        if (((long) r1.f5079d) == r5) goto L_0x0354;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0351, code lost:
        r1.a(r5);
     */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(d.m.a.a.b r24, int r25) throws java.io.IOException {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            java.util.Set<java.lang.Integer> r3 = r0.f5068g
            int r4 = r1.f5079d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            int r3 = r1.f5079d
            int r3 = r3 + 2
            int r4 = r1.f5078c
            if (r3 <= r4) goto L_0x001a
            return
        L_0x001a:
            short r3 = r24.readShort()
            boolean r4 = v
            java.lang.String r5 = "ExifInterface"
            if (r4 == 0) goto L_0x0029
            java.lang.String r4 = "numberOfDirectoryEntry: "
            e.a.a.a.a.b(r4, r3, r5)
        L_0x0029:
            int r4 = r1.f5079d
            int r6 = r3 * 12
            int r6 = r6 + r4
            int r4 = r1.f5078c
            if (r6 > r4) goto L_0x03cd
            if (r3 > 0) goto L_0x0036
            goto L_0x03cd
        L_0x0036:
            r4 = 0
            r6 = r4
        L_0x0038:
            r7 = 5
            if (r4 >= r3) goto L_0x035f
            int r8 = r24.readUnsignedShort()
            int r9 = r24.readUnsignedShort()
            int r12 = r24.readInt()
            int r10 = r1.f5079d
            long r10 = (long) r10
            r13 = 4
            long r10 = r10 + r13
            java.util.HashMap<java.lang.Integer, d.m.a.a$e>[] r15 = i0
            r15 = r15[r2]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r8)
            java.lang.Object r13 = r15.get(r13)
            r15 = r13
            d.m.a.a$e r15 = (d.m.a.a.e) r15
            boolean r13 = v
            r14 = 3
            if (r13 == 0) goto L_0x008f
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r25)
            r7[r6] = r13
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            r13 = 1
            r7[r13] = r6
            if (r15 == 0) goto L_0x0075
            java.lang.String r6 = r15.f5086b
            goto L_0x0076
        L_0x0075:
            r6 = 0
        L_0x0076:
            r13 = 2
            r7[r13] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)
            r7[r14] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)
            r13 = 4
            r7[r13] = r6
            java.lang.String r6 = "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d"
            java.lang.String r6 = java.lang.String.format(r6, r7)
            android.util.Log.d(r5, r6)
        L_0x008f:
            r6 = 7
            if (r15 != 0) goto L_0x009d
            boolean r6 = v
            if (r6 == 0) goto L_0x0131
            java.lang.String r6 = "Skip the tag entry since tag number is not defined: "
            e.a.a.a.a.b(r6, r8, r5)
            goto L_0x0131
        L_0x009d:
            if (r9 <= 0) goto L_0x0128
            int[] r7 = S
            int r7 = r7.length
            if (r9 < r7) goto L_0x00a6
            goto L_0x0128
        L_0x00a6:
            int r7 = r15.f5087c
            if (r7 == r6) goto L_0x00dc
            if (r9 != r6) goto L_0x00ad
            goto L_0x00dc
        L_0x00ad:
            if (r7 == r9) goto L_0x00dc
            int r6 = r15.f5088d
            if (r6 != r9) goto L_0x00b4
            goto L_0x00dc
        L_0x00b4:
            r13 = 4
            if (r7 == r13) goto L_0x00b9
            if (r6 != r13) goto L_0x00bc
        L_0x00b9:
            if (r9 != r14) goto L_0x00bc
            goto L_0x00dc
        L_0x00bc:
            int r6 = r15.f5087c
            r7 = 9
            if (r6 == r7) goto L_0x00c6
            int r6 = r15.f5088d
            if (r6 != r7) goto L_0x00cb
        L_0x00c6:
            r6 = 8
            if (r9 != r6) goto L_0x00cb
            goto L_0x00dc
        L_0x00cb:
            int r6 = r15.f5087c
            r7 = 12
            if (r6 == r7) goto L_0x00d5
            int r6 = r15.f5088d
            if (r6 != r7) goto L_0x00da
        L_0x00d5:
            r6 = 11
            if (r9 != r6) goto L_0x00da
            goto L_0x00dc
        L_0x00da:
            r6 = 0
            goto L_0x00dd
        L_0x00dc:
            r6 = 1
        L_0x00dd:
            if (r6 != 0) goto L_0x0102
            boolean r6 = v
            if (r6 == 0) goto L_0x0131
            java.lang.String r6 = "Skip the tag entry since data format ("
            java.lang.StringBuilder r6 = e.a.a.a.a.a(r6)
            java.lang.String[] r7 = R
            r7 = r7[r9]
            r6.append(r7)
            java.lang.String r7 = ") is unexpected for tag: "
            r6.append(r7)
            java.lang.String r7 = r15.f5086b
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r5, r6)
            goto L_0x0131
        L_0x0102:
            r6 = 7
            if (r9 != r6) goto L_0x0107
            int r9 = r15.f5087c
        L_0x0107:
            long r6 = (long) r12
            int[] r13 = S
            r13 = r13[r9]
            long r13 = (long) r13
            long r13 = r13 * r6
            r6 = 0
            int r6 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x011e
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x011c
            goto L_0x011e
        L_0x011c:
            r6 = 1
            goto L_0x0135
        L_0x011e:
            boolean r6 = v
            if (r6 == 0) goto L_0x0134
            java.lang.String r6 = "Skip the tag entry since the number of components is invalid: "
            e.a.a.a.a.b(r6, r12, r5)
            goto L_0x0134
        L_0x0128:
            boolean r6 = v
            if (r6 == 0) goto L_0x0131
            java.lang.String r6 = "Skip the tag entry since data format is invalid: "
            e.a.a.a.a.b(r6, r9, r5)
        L_0x0131:
            r6 = 0
            r13 = r6
        L_0x0134:
            r6 = 0
        L_0x0135:
            if (r6 != 0) goto L_0x0141
            r1.a(r10)
            r16 = r3
            r17 = r4
        L_0x013e:
            r2 = r5
            goto L_0x0354
        L_0x0141:
            r6 = 4
            int r6 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            java.lang.String r7 = "Compression"
            if (r6 <= 0) goto L_0x01f1
            int r6 = r24.readInt()
            boolean r16 = v
            if (r16 == 0) goto L_0x0159
            r16 = r3
            java.lang.String r3 = "seek to data offset: "
            e.a.a.a.a.b(r3, r6, r5)
            goto L_0x015b
        L_0x0159:
            r16 = r3
        L_0x015b:
            int r3 = r0.f5065d
            r17 = r4
            r4 = 7
            if (r3 != r4) goto L_0x01bd
            java.lang.String r3 = r15.f5086b
            java.lang.String r4 = "MakerNote"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x016f
            r0.p = r6
            goto L_0x01b8
        L_0x016f:
            r3 = 6
            if (r2 != r3) goto L_0x01b8
            java.lang.String r3 = r15.f5086b
            java.lang.String r4 = "ThumbnailImage"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x01b8
            r0.q = r6
            r0.r = r12
            java.nio.ByteOrder r3 = r0.f5069h
            r4 = 6
            d.m.a.a$d r3 = d.m.a.a.d.a(r4, r3)
            int r4 = r0.q
            r18 = r8
            r19 = r9
            long r8 = (long) r4
            java.nio.ByteOrder r4 = r0.f5069h
            d.m.a.a$d r4 = d.m.a.a.d.a(r8, r4)
            int r8 = r0.r
            long r8 = (long) r8
            java.nio.ByteOrder r2 = r0.f5069h
            d.m.a.a$d r2 = d.m.a.a.d.a(r8, r2)
            java.util.HashMap<java.lang.String, d.m.a.a$d>[] r8 = r0.f5067f
            r9 = 4
            r8 = r8[r9]
            r8.put(r7, r3)
            java.util.HashMap<java.lang.String, d.m.a.a$d>[] r3 = r0.f5067f
            r3 = r3[r9]
            java.lang.String r8 = "JPEGInterchangeFormat"
            r3.put(r8, r4)
            java.util.HashMap<java.lang.String, d.m.a.a$d>[] r3 = r0.f5067f
            r3 = r3[r9]
            java.lang.String r4 = "JPEGInterchangeFormatLength"
            r3.put(r4, r2)
            goto L_0x01d1
        L_0x01b8:
            r18 = r8
            r19 = r9
            goto L_0x01d1
        L_0x01bd:
            r18 = r8
            r19 = r9
            r2 = 10
            if (r3 != r2) goto L_0x01d1
            java.lang.String r2 = r15.f5086b
            java.lang.String r3 = "JpgFromRaw"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x01d1
            r0.s = r6
        L_0x01d1:
            long r2 = (long) r6
            long r8 = r2 + r13
            int r4 = r1.f5078c
            r20 = r12
            r21 = r13
            long r12 = (long) r4
            int r4 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r4 > 0) goto L_0x01e3
            r1.a(r2)
            goto L_0x01fd
        L_0x01e3:
            boolean r2 = v
            if (r2 == 0) goto L_0x01ec
            java.lang.String r2 = "Skip the tag entry since data offset is invalid: "
            e.a.a.a.a.b(r2, r6, r5)
        L_0x01ec:
            r1.a(r10)
            goto L_0x013e
        L_0x01f1:
            r16 = r3
            r17 = r4
            r18 = r8
            r19 = r9
            r20 = r12
            r21 = r13
        L_0x01fd:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r2 = l0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r18)
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            boolean r3 = v
            if (r3 == 0) goto L_0x022c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "nextIfdType: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = " byteCount: "
            r3.append(r4)
            r13 = r21
            r3.append(r13)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r5, r3)
            goto L_0x022e
        L_0x022c:
            r13 = r21
        L_0x022e:
            if (r2 == 0) goto L_0x02df
            r3 = -1
            r6 = 3
            r9 = r19
            if (r9 == r6) goto L_0x0256
            r6 = 4
            if (r9 == r6) goto L_0x0251
            r6 = 8
            if (r9 == r6) goto L_0x024c
            r6 = 9
            if (r9 == r6) goto L_0x0247
            r6 = 13
            if (r9 == r6) goto L_0x0247
            goto L_0x025b
        L_0x0247:
            int r3 = r24.readInt()
            goto L_0x025a
        L_0x024c:
            short r3 = r24.readShort()
            goto L_0x025a
        L_0x0251:
            long r3 = r24.a()
            goto L_0x025b
        L_0x0256:
            int r3 = r24.readUnsignedShort()
        L_0x025a:
            long r3 = (long) r3
        L_0x025b:
            boolean r6 = v
            r7 = 2
            if (r6 == 0) goto L_0x0277
            java.lang.Object[] r6 = new java.lang.Object[r7]
            java.lang.Long r7 = java.lang.Long.valueOf(r3)
            r8 = 0
            r6[r8] = r7
            java.lang.String r7 = r15.f5086b
            r8 = 1
            r6[r8] = r7
            java.lang.String r7 = "Offset: %d, tagName: %s"
            java.lang.String r6 = java.lang.String.format(r7, r6)
            android.util.Log.d(r5, r6)
        L_0x0277:
            r6 = 0
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x02c2
            int r6 = r1.f5078c
            long r6 = (long) r6
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x02c2
            java.util.Set<java.lang.Integer> r6 = r0.f5068g
            int r7 = (int) r3
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r6 = r6.contains(r7)
            if (r6 != 0) goto L_0x029c
            r1.a(r3)
            int r2 = r2.intValue()
            r0.b(r1, r2)
            goto L_0x02da
        L_0x029c:
            boolean r6 = v
            if (r6 == 0) goto L_0x02da
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Skip jump into the IFD since it has already been read: IfdType "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = " (at "
            r6.append(r2)
            r6.append(r3)
            java.lang.String r2 = ")"
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            android.util.Log.d(r5, r2)
            goto L_0x02da
        L_0x02c2:
            boolean r2 = v
            if (r2 == 0) goto L_0x02da
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "Skip jump into the IFD since its offset is invalid: "
            r2.append(r6)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r5, r2)
        L_0x02da:
            r1.a(r10)
            goto L_0x013e
        L_0x02df:
            r9 = r19
            int r2 = r1.f5079d
            int r3 = r0.o
            int r2 = r2 + r3
            int r3 = (int) r13
            byte[] r3 = new byte[r3]
            r1.readFully(r3)
            d.m.a.a$d r4 = new d.m.a.a$d
            long r13 = (long) r2
            r11 = r10
            r10 = r4
            r2 = r5
            r5 = r11
            r11 = r9
            r12 = r20
            r8 = r15
            r15 = r3
            r10.<init>(r11, r12, r13, r15)
            java.util.HashMap<java.lang.String, d.m.a.a$d>[] r3 = r0.f5067f
            r3 = r3[r25]
            java.lang.String r9 = r8.f5086b
            r3.put(r9, r4)
            java.lang.String r3 = r8.f5086b
            java.lang.String r9 = "DNGVersion"
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x0311
            r3 = 3
            r0.f5065d = r3
        L_0x0311:
            java.lang.String r3 = r8.f5086b
            java.lang.String r9 = "Make"
            boolean r3 = r9.equals(r3)
            if (r3 != 0) goto L_0x0325
            java.lang.String r3 = r8.f5086b
            java.lang.String r9 = "Model"
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x0333
        L_0x0325:
            java.nio.ByteOrder r3 = r0.f5069h
            java.lang.String r3 = r4.c(r3)
            java.lang.String r9 = "PENTAX"
            boolean r3 = r3.contains(r9)
            if (r3 != 0) goto L_0x0346
        L_0x0333:
            java.lang.String r3 = r8.f5086b
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x034a
            java.nio.ByteOrder r3 = r0.f5069h
            int r3 = r4.b(r3)
            r4 = 65535(0xffff, float:9.1834E-41)
            if (r3 != r4) goto L_0x034a
        L_0x0346:
            r3 = 8
            r0.f5065d = r3
        L_0x034a:
            int r3 = r1.f5079d
            long r3 = (long) r3
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0354
            r1.a(r5)
        L_0x0354:
            int r4 = r17 + 1
            short r4 = (short) r4
            r6 = 0
            r5 = r2
            r3 = r16
            r2 = r25
            goto L_0x0038
        L_0x035f:
            r2 = r5
            int r3 = r1.f5079d
            int r3 = r3 + 4
            int r4 = r1.f5078c
            if (r3 > r4) goto L_0x03cd
            int r3 = r24.readInt()
            boolean r4 = v
            if (r4 == 0) goto L_0x0383
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "nextIfdOffset: %d"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            android.util.Log.d(r2, r4)
        L_0x0383:
            long r4 = (long) r3
            r8 = 0
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x03c4
            int r6 = r1.f5078c
            if (r3 >= r6) goto L_0x03c4
            java.util.Set<java.lang.Integer> r6 = r0.f5068g
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            boolean r6 = r6.contains(r8)
            if (r6 != 0) goto L_0x03ba
            r1.a(r4)
            java.util.HashMap<java.lang.String, d.m.a.a$d>[] r2 = r0.f5067f
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x03ac
            r0.b(r1, r3)
            goto L_0x03cd
        L_0x03ac:
            java.util.HashMap<java.lang.String, d.m.a.a$d>[] r2 = r0.f5067f
            r2 = r2[r7]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x03cd
            r0.b(r1, r7)
            goto L_0x03cd
        L_0x03ba:
            boolean r1 = v
            if (r1 == 0) goto L_0x03cd
            java.lang.String r1 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            e.a.a.a.a.b(r1, r3, r2)
            goto L_0x03cd
        L_0x03c4:
            boolean r1 = v
            if (r1 == 0) goto L_0x03cd
            java.lang.String r1 = "Stop reading file since a wrong offset may cause an infinite loop: "
            e.a.a.a.a.b(r1, r3, r2)
        L_0x03cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.m.a.a.b(d.m.a.a$b, int):void");
    }

    public final void a(InputStream inputStream) {
        if (inputStream != 0) {
            int i2 = 0;
            while (i2 < e0.length) {
                try {
                    this.f5067f[i2] = new HashMap<>();
                    i2++;
                } catch (IOException e2) {
                    this.t = false;
                    if (v) {
                        Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e2);
                    }
                    a();
                    if (!v) {
                        return;
                    }
                } catch (Throwable th) {
                    a();
                    if (v) {
                        c();
                    }
                    throw th;
                }
            }
            if (!this.f5066e) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                this.f5065d = a(bufferedInputStream);
                inputStream = bufferedInputStream;
            }
            b bVar = new b(inputStream, ByteOrder.BIG_ENDIAN);
            if (!this.f5066e) {
                switch (this.f5065d) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 11:
                        e(bVar);
                        break;
                    case 4:
                        a(bVar, 0, 0);
                        break;
                    case 7:
                        b(bVar);
                        break;
                    case 9:
                        d(bVar);
                        break;
                    case 10:
                        f(bVar);
                        break;
                    case 12:
                        a(bVar);
                        break;
                    case 13:
                        c(bVar);
                        break;
                    case 14:
                        h(bVar);
                        break;
                }
            } else {
                g(bVar);
            }
            j(bVar);
            this.t = true;
            a();
            if (!v) {
                return;
            }
            c();
            return;
        }
        throw new NullPointerException("inputstream shouldn't be null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00d1, code lost:
        if (r8 == null) goto L_0x00d4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0111 A[SYNTHETIC, Splitter:B:102:0x0111] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ca A[Catch:{ all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.io.BufferedInputStream r18) throws java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = 5000(0x1388, float:7.006E-42)
            r0.mark(r2)
            byte[] r3 = new byte[r2]
            r0.read(r3)
            r18.reset()
            r4 = 0
            r0 = r4
        L_0x0013:
            byte[] r5 = y
            int r6 = r5.length
            if (r0 >= r6) goto L_0x0023
            byte r6 = r3[r0]
            byte r5 = r5[r0]
            if (r6 == r5) goto L_0x0020
            r0 = r4
            goto L_0x0024
        L_0x0020:
            int r0 = r0 + 1
            goto L_0x0013
        L_0x0023:
            r0 = 1
        L_0x0024:
            r5 = 4
            if (r0 == 0) goto L_0x0028
            return r5
        L_0x0028:
            java.nio.charset.Charset r0 = java.nio.charset.Charset.defaultCharset()
            java.lang.String r6 = "FUJIFILMCCD-RAW"
            byte[] r0 = r6.getBytes(r0)
            r6 = r4
        L_0x0033:
            int r8 = r0.length
            if (r6 >= r8) goto L_0x0041
            byte r8 = r3[r6]
            byte r9 = r0[r6]
            if (r8 == r9) goto L_0x003e
            r0 = r4
            goto L_0x0042
        L_0x003e:
            int r6 = r6 + 1
            goto L_0x0033
        L_0x0041:
            r0 = 1
        L_0x0042:
            if (r0 == 0) goto L_0x0047
            r0 = 9
            return r0
        L_0x0047:
            d.m.a.a$b r8 = new d.m.a.a$b     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            r8.<init>(r3)     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            int r0 = r8.readInt()     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
            long r9 = (long) r0     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
            byte[] r0 = new byte[r5]     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
            r8.read(r0)     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
            byte[] r11 = z     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
            boolean r0 = java.util.Arrays.equals(r0, r11)     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
            if (r0 != 0) goto L_0x0063
        L_0x005e:
            r8.close()
            goto L_0x00d4
        L_0x0063:
            r11 = 1
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            r13 = 16
            r15 = 8
            if (r0 != 0) goto L_0x0076
            long r9 = r8.readLong()     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 >= 0) goto L_0x0077
            goto L_0x005e
        L_0x0076:
            r13 = r15
        L_0x0077:
            long r6 = (long) r2     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
            int r0 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x007d
            r9 = r6
        L_0x007d:
            long r9 = r9 - r13
            int r0 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r0 >= 0) goto L_0x0083
            goto L_0x005e
        L_0x0083:
            byte[] r0 = new byte[r5]     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
            r6 = 0
            r2 = r4
            r13 = r2
        L_0x0089:
            r14 = 4
            long r14 = r9 / r14
            int r14 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r14 >= 0) goto L_0x005e
            int r14 = r8.read(r0)     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
            if (r14 == r5) goto L_0x0098
            goto L_0x005e
        L_0x0098:
            int r14 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r14 != 0) goto L_0x009d
            goto L_0x00b9
        L_0x009d:
            byte[] r14 = A     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
            boolean r14 = java.util.Arrays.equals(r0, r14)     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
            if (r14 == 0) goto L_0x00a7
            r2 = 1
            goto L_0x00b0
        L_0x00a7:
            byte[] r14 = B     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
            boolean r14 = java.util.Arrays.equals(r0, r14)     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
            if (r14 == 0) goto L_0x00b0
            r13 = 1
        L_0x00b0:
            if (r2 == 0) goto L_0x00b9
            if (r13 == 0) goto L_0x00b9
            r8.close()
            r0 = 1
            goto L_0x00d5
        L_0x00b9:
            long r6 = r6 + r11
            goto L_0x0089
        L_0x00bb:
            r0 = move-exception
            goto L_0x018d
        L_0x00be:
            r0 = move-exception
            goto L_0x00c6
        L_0x00c0:
            r0 = move-exception
            r6 = 0
            goto L_0x018c
        L_0x00c4:
            r0 = move-exception
            r8 = 0
        L_0x00c6:
            boolean r2 = v     // Catch:{ all -> 0x018a }
            if (r2 == 0) goto L_0x00d1
            java.lang.String r2 = "ExifInterface"
            java.lang.String r6 = "Exception parsing HEIF file type box."
            android.util.Log.d(r2, r6, r0)     // Catch:{ all -> 0x018a }
        L_0x00d1:
            if (r8 == 0) goto L_0x00d4
            goto L_0x005e
        L_0x00d4:
            r0 = r4
        L_0x00d5:
            if (r0 == 0) goto L_0x00da
            r0 = 12
            return r0
        L_0x00da:
            d.m.a.a$b r2 = new d.m.a.a$b     // Catch:{ Exception -> 0x0106, all -> 0x00fe }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0106, all -> 0x00fe }
            java.nio.ByteOrder r0 = r1.i(r2)     // Catch:{ Exception -> 0x0107, all -> 0x00fb }
            r1.f5069h = r0     // Catch:{ Exception -> 0x0107, all -> 0x00fb }
            r2.f5077b = r0     // Catch:{ Exception -> 0x0107, all -> 0x00fb }
            short r0 = r2.readShort()     // Catch:{ Exception -> 0x0107, all -> 0x00fb }
            r6 = 20306(0x4f52, float:2.8455E-41)
            if (r0 == r6) goto L_0x00f6
            r6 = 21330(0x5352, float:2.989E-41)
            if (r0 != r6) goto L_0x00f4
            goto L_0x00f6
        L_0x00f4:
            r0 = r4
            goto L_0x00f7
        L_0x00f6:
            r0 = 1
        L_0x00f7:
            r2.close()
            goto L_0x010d
        L_0x00fb:
            r0 = move-exception
            r6 = r2
            goto L_0x0100
        L_0x00fe:
            r0 = move-exception
            r6 = 0
        L_0x0100:
            if (r6 == 0) goto L_0x0105
            r6.close()
        L_0x0105:
            throw r0
        L_0x0106:
            r2 = 0
        L_0x0107:
            if (r2 == 0) goto L_0x010c
            r2.close()
        L_0x010c:
            r0 = r4
        L_0x010d:
            if (r0 == 0) goto L_0x0111
            r0 = 7
            return r0
        L_0x0111:
            d.m.a.a$b r2 = new d.m.a.a$b     // Catch:{ Exception -> 0x013a, all -> 0x0132 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x013a, all -> 0x0132 }
            java.nio.ByteOrder r0 = r1.i(r2)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            r1.f5069h = r0     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            r2.f5077b = r0     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            short r0 = r2.readShort()     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            r6 = 85
            if (r0 != r6) goto L_0x0128
            r0 = 1
            goto L_0x0129
        L_0x0128:
            r0 = r4
        L_0x0129:
            r2.close()
            goto L_0x0141
        L_0x012d:
            r0 = move-exception
            r6 = r2
            goto L_0x0134
        L_0x0130:
            r6 = r2
            goto L_0x013b
        L_0x0132:
            r0 = move-exception
            r6 = 0
        L_0x0134:
            if (r6 == 0) goto L_0x0139
            r6.close()
        L_0x0139:
            throw r0
        L_0x013a:
            r6 = 0
        L_0x013b:
            if (r6 == 0) goto L_0x0140
            r6.close()
        L_0x0140:
            r0 = r4
        L_0x0141:
            if (r0 == 0) goto L_0x0146
            r0 = 10
            return r0
        L_0x0146:
            r0 = r4
        L_0x0147:
            byte[] r2 = E
            int r6 = r2.length
            if (r0 >= r6) goto L_0x0157
            byte r6 = r3[r0]
            byte r2 = r2[r0]
            if (r6 == r2) goto L_0x0154
            r0 = r4
            goto L_0x0158
        L_0x0154:
            int r0 = r0 + 1
            goto L_0x0147
        L_0x0157:
            r0 = 1
        L_0x0158:
            if (r0 == 0) goto L_0x015d
            r0 = 13
            return r0
        L_0x015d:
            r0 = r4
        L_0x015e:
            byte[] r2 = I
            int r6 = r2.length
            if (r0 >= r6) goto L_0x016e
            byte r6 = r3[r0]
            byte r2 = r2[r0]
            if (r6 == r2) goto L_0x016b
        L_0x0169:
            r7 = r4
            goto L_0x0184
        L_0x016b:
            int r0 = r0 + 1
            goto L_0x015e
        L_0x016e:
            r0 = r4
        L_0x016f:
            byte[] r2 = J
            int r6 = r2.length
            if (r0 >= r6) goto L_0x0183
            byte[] r6 = I
            int r6 = r6.length
            int r6 = r6 + r0
            int r6 = r6 + r5
            byte r6 = r3[r6]
            byte r2 = r2[r0]
            if (r6 == r2) goto L_0x0180
            goto L_0x0169
        L_0x0180:
            int r0 = r0 + 1
            goto L_0x016f
        L_0x0183:
            r7 = 1
        L_0x0184:
            if (r7 == 0) goto L_0x0189
            r0 = 14
            return r0
        L_0x0189:
            return r4
        L_0x018a:
            r0 = move-exception
            r6 = r8
        L_0x018c:
            r8 = r6
        L_0x018d:
            if (r8 == 0) goto L_0x0192
            r8.close()
        L_0x0192:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.m.a.a.a(java.io.BufferedInputStream):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e9 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(d.m.a.a.b r19, int r20, int r21) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            boolean r4 = v
            java.lang.String r5 = "ExifInterface"
            if (r4 == 0) goto L_0x0022
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "getJpegAttributes starting with: "
            r4.append(r6)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r5, r4)
        L_0x0022:
            java.nio.ByteOrder r4 = java.nio.ByteOrder.BIG_ENDIAN
            r1.f5077b = r4
            long r6 = (long) r2
            r1.a(r6)
            byte r4 = r19.readByte()
            java.lang.String r6 = "Invalid marker: "
            r7 = -1
            if (r4 != r7) goto L_0x01c3
            r8 = 1
            int r2 = r2 + r8
            byte r9 = r19.readByte()
            r10 = -40
            if (r9 != r10) goto L_0x01ac
            int r2 = r2 + r8
        L_0x003e:
            byte r4 = r19.readByte()
            if (r4 != r7) goto L_0x0193
            int r2 = r2 + r8
            byte r4 = r19.readByte()
            boolean r6 = v
            if (r6 == 0) goto L_0x0063
            java.lang.String r6 = "Found JPEG segment indicator: "
            java.lang.StringBuilder r6 = e.a.a.a.a.a(r6)
            r7 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r7 = java.lang.Integer.toHexString(r7)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r5, r6)
        L_0x0063:
            int r2 = r2 + r8
            r6 = -39
            if (r4 == r6) goto L_0x018e
            r6 = -38
            if (r4 != r6) goto L_0x006e
            goto L_0x018e
        L_0x006e:
            int r6 = r19.readUnsignedShort()
            int r6 = r6 + -2
            int r2 = r2 + 2
            boolean r7 = v
            if (r7 == 0) goto L_0x009f
            java.lang.String r7 = "JPEG segment: "
            java.lang.StringBuilder r7 = e.a.a.a.a.a(r7)
            r9 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r9 = java.lang.Integer.toHexString(r9)
            r7.append(r9)
            java.lang.String r9 = " (length: "
            r7.append(r9)
            int r9 = r6 + 2
            r7.append(r9)
            java.lang.String r9 = ")"
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r5, r7)
        L_0x009f:
            java.lang.String r7 = "Invalid length"
            if (r6 < 0) goto L_0x0188
            r9 = -31
            r10 = 0
            if (r4 == r9) goto L_0x011f
            r9 = -2
            if (r4 == r9) goto L_0x00f4
            switch(r4) {
                case -64: goto L_0x00b8;
                case -63: goto L_0x00b8;
                case -62: goto L_0x00b8;
                case -61: goto L_0x00b8;
                default: goto L_0x00ae;
            }
        L_0x00ae:
            switch(r4) {
                case -59: goto L_0x00b8;
                case -58: goto L_0x00b8;
                case -57: goto L_0x00b8;
                default: goto L_0x00b1;
            }
        L_0x00b1:
            switch(r4) {
                case -55: goto L_0x00b8;
                case -54: goto L_0x00b8;
                case -53: goto L_0x00b8;
                default: goto L_0x00b4;
            }
        L_0x00b4:
            switch(r4) {
                case -51: goto L_0x00b8;
                case -50: goto L_0x00b8;
                case -49: goto L_0x00b8;
                default: goto L_0x00b7;
            }
        L_0x00b7:
            goto L_0x00f1
        L_0x00b8:
            int r4 = r1.skipBytes(r8)
            if (r4 != r8) goto L_0x00e9
            java.util.HashMap<java.lang.String, d.m.a.a$d>[] r4 = r0.f5067f
            r4 = r4[r3]
            int r9 = r19.readUnsignedShort()
            long r9 = (long) r9
            java.nio.ByteOrder r11 = r0.f5069h
            d.m.a.a$d r9 = d.m.a.a.d.a(r9, r11)
            java.lang.String r10 = "ImageLength"
            r4.put(r10, r9)
            java.util.HashMap<java.lang.String, d.m.a.a$d>[] r4 = r0.f5067f
            r4 = r4[r3]
            int r9 = r19.readUnsignedShort()
            long r9 = (long) r9
            java.nio.ByteOrder r11 = r0.f5069h
            d.m.a.a$d r9 = d.m.a.a.d.a(r9, r11)
            java.lang.String r10 = "ImageWidth"
            r4.put(r10, r9)
            int r6 = r6 + -5
            goto L_0x00f1
        L_0x00e9:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid SOFx"
            r1.<init>(r2)
            throw r1
        L_0x00f1:
            r10 = r6
            goto L_0x016e
        L_0x00f4:
            byte[] r4 = new byte[r6]
            int r9 = r1.read(r4)
            if (r9 != r6) goto L_0x0117
            java.lang.String r6 = "UserComment"
            java.lang.String r9 = r0.a(r6)
            if (r9 != 0) goto L_0x016e
            java.util.HashMap<java.lang.String, d.m.a.a$d>[] r9 = r0.f5067f
            r9 = r9[r8]
            java.lang.String r11 = new java.lang.String
            java.nio.charset.Charset r12 = m0
            r11.<init>(r4, r12)
            d.m.a.a$d r4 = d.m.a.a.d.a(r11)
            r9.put(r6, r4)
            goto L_0x016e
        L_0x0117:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid exif"
            r1.<init>(r2)
            throw r1
        L_0x011f:
            byte[] r4 = new byte[r6]
            r1.readFully(r4)
            int r9 = r2 + r6
            byte[] r11 = n0
            boolean r11 = a(r4, r11)
            if (r11 == 0) goto L_0x013d
            byte[] r10 = n0
            int r11 = r10.length
            int r2 = r2 + r11
            int r10 = r10.length
            byte[] r4 = java.util.Arrays.copyOfRange(r4, r10, r6)
            r0.o = r2
            r0.a(r4, r3)
            goto L_0x016c
        L_0x013d:
            byte[] r11 = o0
            boolean r11 = a(r4, r11)
            if (r11 == 0) goto L_0x016c
            byte[] r11 = o0
            int r12 = r11.length
            int r2 = r2 + r12
            int r11 = r11.length
            byte[] r4 = java.util.Arrays.copyOfRange(r4, r11, r6)
            java.lang.String r6 = "Xmp"
            java.lang.String r11 = r0.a(r6)
            if (r11 != 0) goto L_0x016c
            java.util.HashMap<java.lang.String, d.m.a.a$d>[] r8 = r0.f5067f
            r8 = r8[r10]
            d.m.a.a$d r10 = new d.m.a.a$d
            r13 = 1
            int r14 = r4.length
            long r11 = (long) r2
            r15 = r11
            r12 = r10
            r17 = r4
            r12.<init>(r13, r14, r15, r17)
            r8.put(r6, r10)
            r8 = 1
            r0.u = r8
        L_0x016c:
            r10 = 0
            r2 = r9
        L_0x016e:
            if (r10 < 0) goto L_0x0182
            int r4 = r1.skipBytes(r10)
            if (r4 != r10) goto L_0x017a
            int r2 = r2 + r10
            r7 = -1
            goto L_0x003e
        L_0x017a:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid JPEG segment"
            r1.<init>(r2)
            throw r1
        L_0x0182:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r7)
            throw r1
        L_0x0188:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r7)
            throw r1
        L_0x018e:
            java.nio.ByteOrder r2 = r0.f5069h
            r1.f5077b = r2
            return
        L_0x0193:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid marker:"
            java.lang.StringBuilder r2 = e.a.a.a.a.a(r2)
            r3 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01ac:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = e.a.a.a.a.a(r6)
            r3 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01c3:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = e.a.a.a.a.a(r6)
            r3 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.m.a.a.a(d.m.a.a$b, int, int):void");
    }

    public final void a(b bVar) throws IOException {
        String str;
        String str2;
        String str3 = "yes";
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(new C0049a(this, bVar));
            String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
            String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
            String str4 = null;
            if (str3.equals(extractMetadata3)) {
                str4 = mediaMetadataRetriever.extractMetadata(29);
                str2 = mediaMetadataRetriever.extractMetadata(30);
                str = mediaMetadataRetriever.extractMetadata(31);
            } else if (str3.equals(extractMetadata4)) {
                str4 = mediaMetadataRetriever.extractMetadata(18);
                str2 = mediaMetadataRetriever.extractMetadata(19);
                str = mediaMetadataRetriever.extractMetadata(24);
            } else {
                str2 = null;
                str = null;
            }
            if (str4 != null) {
                this.f5067f[0].put("ImageWidth", d.a(Integer.parseInt(str4), this.f5069h));
            }
            if (str2 != null) {
                this.f5067f[0].put("ImageLength", d.a(Integer.parseInt(str2), this.f5069h));
            }
            if (str != null) {
                int i2 = 1;
                int parseInt = Integer.parseInt(str);
                if (parseInt == 90) {
                    i2 = 6;
                } else if (parseInt == 180) {
                    i2 = 3;
                } else if (parseInt == 270) {
                    i2 = 8;
                }
                this.f5067f[0].put("Orientation", d.a(i2, this.f5069h));
            }
            if (!(extractMetadata == null || extractMetadata2 == null)) {
                int parseInt2 = Integer.parseInt(extractMetadata);
                int parseInt3 = Integer.parseInt(extractMetadata2);
                if (parseInt3 > 6) {
                    bVar.a((long) parseInt2);
                    byte[] bArr = new byte[6];
                    if (bVar.read(bArr) == 6) {
                        int i3 = parseInt2 + 6;
                        int i4 = parseInt3 - 6;
                        if (Arrays.equals(bArr, n0)) {
                            byte[] bArr2 = new byte[i4];
                            if (bVar.read(bArr2) == i4) {
                                this.o = i3;
                                a(bArr2, 0);
                            } else {
                                throw new IOException("Can't read exif");
                            }
                        } else {
                            throw new IOException("Invalid identifier");
                        }
                    } else {
                        throw new IOException("Can't read identifier");
                    }
                } else {
                    throw new IOException("Invalid exif length");
                }
            }
            if (v) {
                StringBuilder sb = new StringBuilder();
                sb.append("Heif meta: ");
                sb.append(str4);
                sb.append(Config.EVENT_HEAT_X);
                sb.append(str2);
                sb.append(", rotation ");
                sb.append(str);
                Log.d("ExifInterface", sb.toString());
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public final void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (v) {
            StringBuilder sb = new StringBuilder();
            sb.append("saveJpegAttributes starting with (inputStream: ");
            sb.append(inputStream);
            sb.append(", outputStream: ");
            sb.append(outputStream);
            sb.append(")");
            Log.d("ExifInterface", sb.toString());
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        c cVar = new c(outputStream, ByteOrder.BIG_ENDIAN);
        String str = "Invalid marker";
        if (dataInputStream.readByte() == -1) {
            cVar.f5080a.write(-1);
            if (dataInputStream.readByte() == -40) {
                cVar.f5080a.write(-40);
                d dVar = null;
                String str2 = "Xmp";
                if (a(str2) != null && this.u) {
                    dVar = (d) this.f5067f[0].remove(str2);
                }
                cVar.f5080a.write(-1);
                cVar.f5080a.write(-31);
                a(cVar);
                if (dVar != null) {
                    this.f5067f[0].put(str2, dVar);
                }
                byte[] bArr = new byte[4096];
                while (dataInputStream.readByte() == -1) {
                    byte readByte = dataInputStream.readByte();
                    if (readByte == -39 || readByte == -38) {
                        cVar.f5080a.write(-1);
                        cVar.f5080a.write(readByte);
                        d(dataInputStream, cVar);
                        return;
                    }
                    String str3 = "Invalid length";
                    if (readByte != -31) {
                        cVar.f5080a.write(-1);
                        cVar.f5080a.write(readByte);
                        int readUnsignedShort = dataInputStream.readUnsignedShort();
                        cVar.a((short) readUnsignedShort);
                        int i2 = readUnsignedShort - 2;
                        if (i2 >= 0) {
                            while (i2 > 0) {
                                int read = dataInputStream.read(bArr, 0, Math.min(i2, 4096));
                                if (read < 0) {
                                    break;
                                }
                                cVar.f5080a.write(bArr, 0, read);
                                i2 -= read;
                            }
                        } else {
                            throw new IOException(str3);
                        }
                    } else {
                        int readUnsignedShort2 = dataInputStream.readUnsignedShort() - 2;
                        if (readUnsignedShort2 >= 0) {
                            byte[] bArr2 = new byte[6];
                            if (readUnsignedShort2 >= 6) {
                                if (dataInputStream.read(bArr2) != 6) {
                                    throw new IOException("Invalid exif");
                                } else if (Arrays.equals(bArr2, n0)) {
                                    int i3 = readUnsignedShort2 - 6;
                                    if (dataInputStream.skipBytes(i3) != i3) {
                                        throw new IOException(str3);
                                    }
                                }
                            }
                            cVar.f5080a.write(-1);
                            cVar.f5080a.write(readByte);
                            cVar.a((short) (readUnsignedShort2 + 2));
                            if (readUnsignedShort2 >= 6) {
                                readUnsignedShort2 -= 6;
                                cVar.f5080a.write(bArr2);
                            }
                            while (readUnsignedShort2 > 0) {
                                int read2 = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort2, 4096));
                                if (read2 < 0) {
                                    break;
                                }
                                cVar.f5080a.write(bArr, 0, read2);
                                readUnsignedShort2 -= read2;
                            }
                        } else {
                            throw new IOException(str3);
                        }
                    }
                }
                throw new IOException(str);
            }
            throw new IOException(str);
        }
        throw new IOException(str);
    }

    public final void a(b bVar, c cVar, byte[] bArr, byte[] bArr2) throws IOException {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (bVar.read(bArr3) != 4) {
                StringBuilder a2 = e.a.a.a.a.a("Encountered invalid length while copying WebP chunks up tochunk type ");
                a2.append(new String(bArr, m0));
                if (bArr2 == null) {
                    str = "";
                } else {
                    StringBuilder a3 = e.a.a.a.a.a(" or ");
                    a3.append(new String(bArr2, m0));
                    str = a3.toString();
                }
                a2.append(str);
                throw new IOException(a2.toString());
            }
            a(bVar, cVar, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    public final void a(b bVar, c cVar, byte[] bArr) throws IOException {
        int readInt = bVar.readInt();
        cVar.f5080a.write(bArr);
        cVar.writeInt(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        a((InputStream) bVar, (OutputStream) cVar, readInt);
    }

    public final void a(byte[] bArr, int i2) throws IOException {
        b bVar = new b(bArr);
        a(bVar, bArr.length);
        b(bVar, i2);
    }

    public final void a() {
        String a2 = a("DateTimeOriginal");
        if (a2 != null) {
            String str = "DateTime";
            if (a(str) == null) {
                this.f5067f[0].put(str, d.a(a2));
            }
        }
        String str2 = "ImageWidth";
        if (a(str2) == null) {
            this.f5067f[0].put(str2, d.a(0, this.f5069h));
        }
        String str3 = "ImageLength";
        if (a(str3) == null) {
            this.f5067f[0].put(str3, d.a(0, this.f5069h));
        }
        String str4 = "Orientation";
        if (a(str4) == null) {
            this.f5067f[0].put(str4, d.a(0, this.f5069h));
        }
        String str5 = "LightSource";
        if (a(str5) == null) {
            this.f5067f[1].put(str5, d.a(0, this.f5069h));
        }
    }

    public final void a(b bVar, int i2) throws IOException {
        ByteOrder i3 = i(bVar);
        this.f5069h = i3;
        bVar.f5077b = i3;
        int readUnsignedShort = bVar.readUnsignedShort();
        int i4 = this.f5065d;
        if (i4 == 7 || i4 == 10 || readUnsignedShort == 42) {
            int readInt = bVar.readInt();
            if (readInt < 8 || readInt >= i2) {
                throw new IOException(e.a.a.a.a.a("Invalid first Ifd offset: ", readInt));
            }
            int i5 = readInt - 8;
            if (i5 > 0 && bVar.skipBytes(i5) != i5) {
                throw new IOException(e.a.a.a.a.a("Couldn't jump to first Ifd: ", i5));
            }
            return;
        }
        StringBuilder a2 = e.a.a.a.a.a("Invalid start code: ");
        a2.append(Integer.toHexString(readUnsignedShort));
        throw new IOException(a2.toString());
    }

    public final void a(b bVar, HashMap hashMap) throws IOException {
        d dVar = (d) hashMap.get("JPEGInterchangeFormat");
        d dVar2 = (d) hashMap.get("JPEGInterchangeFormatLength");
        if (dVar != null && dVar2 != null) {
            int b2 = dVar.b(this.f5069h);
            int b3 = dVar2.b(this.f5069h);
            if (this.f5065d == 7) {
                b2 += this.p;
            }
            int min = Math.min(b3, bVar.f5078c - b2);
            if (b2 > 0 && min > 0) {
                this.f5070i = true;
                int i2 = this.o + b2;
                this.k = i2;
                this.l = min;
                if (this.f5062a == null && this.f5064c == null && this.f5063b == null) {
                    byte[] bArr = new byte[min];
                    bVar.a((long) i2);
                    bVar.readFully(bArr);
                    this.m = bArr;
                }
            }
            if (v) {
                StringBuilder sb = new StringBuilder();
                sb.append("Setting thumbnail attributes with offset: ");
                sb.append(b2);
                sb.append(", length: ");
                sb.append(min);
                Log.d("ExifInterface", sb.toString());
            }
        }
    }

    public final boolean a(HashMap hashMap) throws IOException {
        d dVar = (d) hashMap.get("ImageLength");
        d dVar2 = (d) hashMap.get("ImageWidth");
        if (!(dVar == null || dVar2 == null)) {
            int b2 = dVar.b(this.f5069h);
            int b3 = dVar2.b(this.f5069h);
            if (b2 <= 512 && b3 <= 512) {
                return true;
            }
        }
        return false;
    }

    public final int a(c cVar) throws IOException {
        c cVar2 = cVar;
        e[][] eVarArr = e0;
        int[] iArr = new int[eVarArr.length];
        int[] iArr2 = new int[eVarArr.length];
        for (e eVar : f0) {
            c(eVar.f5086b);
        }
        c(g0.f5086b);
        c(h0.f5086b);
        for (int i2 = 0; i2 < e0.length; i2++) {
            for (Object obj : this.f5067f[i2].entrySet().toArray()) {
                Entry entry = (Entry) obj;
                if (entry.getValue() == null) {
                    this.f5067f[i2].remove(entry.getKey());
                }
            }
        }
        if (!this.f5067f[1].isEmpty()) {
            this.f5067f[0].put(f0[1].f5086b, d.a(0, this.f5069h));
        }
        int i3 = 2;
        if (!this.f5067f[2].isEmpty()) {
            this.f5067f[0].put(f0[2].f5086b, d.a(0, this.f5069h));
        }
        if (!this.f5067f[3].isEmpty()) {
            this.f5067f[1].put(f0[3].f5086b, d.a(0, this.f5069h));
        }
        if (this.f5070i) {
            this.f5067f[4].put(g0.f5086b, d.a(0, this.f5069h));
            this.f5067f[4].put(h0.f5086b, d.a((long) this.l, this.f5069h));
        }
        for (int i4 = 0; i4 < e0.length; i4++) {
            int i5 = 0;
            for (Entry value : this.f5067f[i4].entrySet()) {
                d dVar = (d) value.getValue();
                if (dVar != null) {
                    int i6 = S[dVar.f5082a] * dVar.f5083b;
                    if (i6 > 4) {
                        i5 += i6;
                    }
                } else {
                    throw null;
                }
            }
            iArr2[i4] = iArr2[i4] + i5;
        }
        int i7 = 8;
        for (int i8 = 0; i8 < e0.length; i8++) {
            if (!this.f5067f[i8].isEmpty()) {
                iArr[i8] = i7;
                i7 = (this.f5067f[i8].size() * 12) + 2 + 4 + iArr2[i8] + i7;
            }
        }
        if (this.f5070i) {
            this.f5067f[4].put(g0.f5086b, d.a((long) i7, this.f5069h));
            this.k = this.o + i7;
            i7 += this.l;
        }
        if (this.f5065d == 4) {
            i7 += 8;
        }
        if (v) {
            for (int i9 = 0; i9 < e0.length; i9++) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", new Object[]{Integer.valueOf(i9), Integer.valueOf(iArr[i9]), Integer.valueOf(this.f5067f[i9].size()), Integer.valueOf(iArr2[i9]), Integer.valueOf(i7)}));
            }
        }
        if (!this.f5067f[1].isEmpty()) {
            this.f5067f[0].put(f0[1].f5086b, d.a((long) iArr[1], this.f5069h));
        }
        if (!this.f5067f[2].isEmpty()) {
            this.f5067f[0].put(f0[2].f5086b, d.a((long) iArr[2], this.f5069h));
        }
        if (!this.f5067f[3].isEmpty()) {
            this.f5067f[1].put(f0[3].f5086b, d.a((long) iArr[3], this.f5069h));
        }
        int i10 = this.f5065d;
        if (i10 == 4) {
            cVar2.a((short) i7);
            cVar2.f5080a.write(n0);
        } else if (i10 == 13) {
            cVar2.writeInt(i7);
            cVar2.f5080a.write(F);
        } else if (i10 == 14) {
            cVar2.f5080a.write(K);
            cVar2.writeInt(i7);
        }
        cVar2.a(this.f5069h == ByteOrder.BIG_ENDIAN ? (short) 19789 : 18761);
        cVar2.f5081b = this.f5069h;
        cVar2.a((short) 42);
        cVar2.writeInt((int) 8);
        int i11 = 0;
        while (i11 < e0.length) {
            if (!this.f5067f[i11].isEmpty()) {
                cVar2.a((short) this.f5067f[i11].size());
                int size = (this.f5067f[i11].size() * 12) + iArr[i11] + i3 + 4;
                for (Entry entry2 : this.f5067f[i11].entrySet()) {
                    int i12 = ((e) j0[i11].get(entry2.getKey())).f5085a;
                    d dVar2 = (d) entry2.getValue();
                    if (dVar2 != null) {
                        int i13 = S[dVar2.f5082a] * dVar2.f5083b;
                        cVar2.a((short) i12);
                        cVar2.a((short) dVar2.f5082a);
                        cVar2.writeInt(dVar2.f5083b);
                        if (i13 > 4) {
                            cVar2.writeInt((int) ((long) size));
                            size += i13;
                        } else {
                            cVar2.f5080a.write(dVar2.f5084c);
                            if (i13 < 4) {
                                while (i13 < 4) {
                                    cVar2.f5080a.write(0);
                                    i13++;
                                }
                            }
                        }
                    } else {
                        throw null;
                    }
                }
                if (i11 != 0 || this.f5067f[4].isEmpty()) {
                    cVar2.writeInt((int) 0);
                } else {
                    cVar2.writeInt((int) ((long) iArr[4]));
                }
                for (Entry value2 : this.f5067f[i11].entrySet()) {
                    byte[] bArr = ((d) value2.getValue()).f5084c;
                    if (bArr.length > 4) {
                        cVar2.f5080a.write(bArr, 0, bArr.length);
                    }
                }
            }
            i11++;
            i3 = 2;
        }
        if (this.f5070i) {
            cVar2.f5080a.write(b());
        }
        if (this.f5065d == 14 && i7 % 2 == 1) {
            cVar2.f5080a.write(0);
        }
        cVar2.f5081b = ByteOrder.BIG_ENDIAN;
        return i7;
    }

    public final void a(int i2, int i3) throws IOException {
        String str = "ExifInterface";
        if (this.f5067f[i2].isEmpty() || this.f5067f[i3].isEmpty()) {
            if (v) {
                Log.d(str, "Cannot perform swap since only one image data exists");
            }
            return;
        }
        String str2 = "ImageLength";
        d dVar = (d) this.f5067f[i2].get(str2);
        String str3 = "ImageWidth";
        d dVar2 = (d) this.f5067f[i2].get(str3);
        d dVar3 = (d) this.f5067f[i3].get(str2);
        d dVar4 = (d) this.f5067f[i3].get(str3);
        if (dVar == null || dVar2 == null) {
            if (v) {
                Log.d(str, "First image does not contain valid size information");
            }
        } else if (dVar3 != null && dVar4 != null) {
            int b2 = dVar.b(this.f5069h);
            int b3 = dVar2.b(this.f5069h);
            int b4 = dVar3.b(this.f5069h);
            int b5 = dVar4.b(this.f5069h);
            if (b2 < b4 && b3 < b5) {
                HashMap<String, d>[] hashMapArr = this.f5067f;
                HashMap<String, d> hashMap = hashMapArr[i2];
                hashMapArr[i2] = hashMapArr[i3];
                hashMapArr[i3] = hashMap;
            }
        } else if (v) {
            Log.d(str, "Second image does not contain valid size information");
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(FileDescriptor fileDescriptor) {
        try {
            Os.close(fileDescriptor);
        } catch (Exception unused) {
            Log.e("ExifInterface", "Error closing fd.");
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
        byte[] bArr = new byte[8192];
        while (i2 > 0) {
            int min = Math.min(i2, 8192);
            int read = inputStream.read(bArr, 0, min);
            if (read == min) {
                i2 -= read;
                outputStream.write(bArr, 0, read);
            } else {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
        }
    }

    public static long[] a(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jArr[i2] = (long) iArr[i2];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte valueOf : bArr) {
            sb.append(String.format("%02x", new Object[]{Byte.valueOf(valueOf)}));
        }
        return sb.toString();
    }
}
