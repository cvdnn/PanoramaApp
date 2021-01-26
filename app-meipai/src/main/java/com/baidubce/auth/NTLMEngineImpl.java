package com.baidubce.auth;

import android.util.Base64;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import e.a.a.a.a;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class NTLMEngineImpl {
    public static final Charset DEFAULT_CHARSET = Charset.forName("US-ASCII");
    public static final int FLAG_DOMAIN_PRESENT = 4096;
    public static final int FLAG_REQUEST_128BIT_KEY_EXCH = 536870912;
    public static final int FLAG_REQUEST_56BIT_ENCRYPTION = Integer.MIN_VALUE;
    public static final int FLAG_REQUEST_ALWAYS_SIGN = 32768;
    public static final int FLAG_REQUEST_EXPLICIT_KEY_EXCH = 1073741824;
    public static final int FLAG_REQUEST_LAN_MANAGER_KEY = 128;
    public static final int FLAG_REQUEST_NTLM2_SESSION = 524288;
    public static final int FLAG_REQUEST_NTLMv1 = 512;
    public static final int FLAG_REQUEST_SEAL = 32;
    public static final int FLAG_REQUEST_SIGN = 16;
    public static final int FLAG_REQUEST_TARGET = 4;
    public static final int FLAG_REQUEST_UNICODE_ENCODING = 1;
    public static final int FLAG_REQUEST_VERSION = 33554432;
    public static final int FLAG_TARGETINFO_PRESENT = 8388608;
    public static final int FLAG_WORKSTATION_PRESENT = 8192;
    public static final SecureRandom RND_GEN;
    public static final byte[] SIGNATURE;
    public static final String TYPE_1_MESSAGE = new Type1Message().getResponse();
    public static final Charset UNICODE_LITTLE_UNMARKED = Charset.forName("UnicodeLittleUnmarked");

    public static class CipherGen {
        public final byte[] challenge;
        public byte[] clientChallenge;
        public byte[] clientChallenge2;
        public final String domain;
        public byte[] lanManagerSessionKey;
        public byte[] lm2SessionResponse;
        public byte[] lmHash;
        public byte[] lmResponse;
        public byte[] lmUserSessionKey;
        public byte[] lmv2Hash;
        public byte[] lmv2Response;
        public byte[] ntlm2SessionResponse;
        public byte[] ntlm2SessionResponseUserSessionKey;
        public byte[] ntlmHash;
        public byte[] ntlmResponse;
        public byte[] ntlmUserSessionKey;
        public byte[] ntlmv2Blob;
        public byte[] ntlmv2Hash;
        public byte[] ntlmv2Response;
        public byte[] ntlmv2UserSessionKey;
        public final String password;
        public byte[] secondaryKey;
        public final String target;
        public final byte[] targetInformation;
        public byte[] timestamp;
        public final String user;

        public CipherGen(String str, String str2, String str3, byte[] bArr, String str4, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
            this.lmHash = null;
            this.lmResponse = null;
            this.ntlmHash = null;
            this.ntlmResponse = null;
            this.ntlmv2Hash = null;
            this.lmv2Hash = null;
            this.lmv2Response = null;
            this.ntlmv2Blob = null;
            this.ntlmv2Response = null;
            this.ntlm2SessionResponse = null;
            this.lm2SessionResponse = null;
            this.lmUserSessionKey = null;
            this.ntlmUserSessionKey = null;
            this.ntlmv2UserSessionKey = null;
            this.ntlm2SessionResponseUserSessionKey = null;
            this.lanManagerSessionKey = null;
            this.domain = str;
            this.target = str4;
            this.user = str2;
            this.password = str3;
            this.challenge = bArr;
            this.targetInformation = bArr2;
            this.clientChallenge = bArr3;
            this.clientChallenge2 = bArr4;
            this.secondaryKey = bArr5;
            this.timestamp = bArr6;
        }

        public byte[] getClientChallenge() throws NTLMEngineException {
            if (this.clientChallenge == null) {
                this.clientChallenge = NTLMEngineImpl.makeRandomChallenge();
            }
            return this.clientChallenge;
        }

        public byte[] getClientChallenge2() throws NTLMEngineException {
            if (this.clientChallenge2 == null) {
                this.clientChallenge2 = NTLMEngineImpl.makeRandomChallenge();
            }
            return this.clientChallenge2;
        }

        public byte[] getLM2SessionResponse() throws NTLMEngineException {
            if (this.lm2SessionResponse == null) {
                byte[] clientChallenge3 = getClientChallenge();
                byte[] bArr = new byte[24];
                this.lm2SessionResponse = bArr;
                System.arraycopy(clientChallenge3, 0, bArr, 0, clientChallenge3.length);
                byte[] bArr2 = this.lm2SessionResponse;
                Arrays.fill(bArr2, clientChallenge3.length, bArr2.length, 0);
            }
            return this.lm2SessionResponse;
        }

        public byte[] getLMHash() throws NTLMEngineException {
            if (this.lmHash == null) {
                this.lmHash = NTLMEngineImpl.lmHash(this.password);
            }
            return this.lmHash;
        }

        public byte[] getLMResponse() throws NTLMEngineException {
            if (this.lmResponse == null) {
                this.lmResponse = NTLMEngineImpl.lmResponse(getLMHash(), this.challenge);
            }
            return this.lmResponse;
        }

        public byte[] getLMUserSessionKey() throws NTLMEngineException {
            if (this.lmUserSessionKey == null) {
                this.lmUserSessionKey = new byte[16];
                System.arraycopy(getLMHash(), 0, this.lmUserSessionKey, 0, 8);
                Arrays.fill(this.lmUserSessionKey, 8, 16, 0);
            }
            return this.lmUserSessionKey;
        }

        public byte[] getLMv2Hash() throws NTLMEngineException {
            if (this.lmv2Hash == null) {
                this.lmv2Hash = NTLMEngineImpl.lmv2Hash(this.domain, this.user, getNTLMHash());
            }
            return this.lmv2Hash;
        }

        public byte[] getLMv2Response() throws NTLMEngineException {
            if (this.lmv2Response == null) {
                this.lmv2Response = NTLMEngineImpl.lmv2Response(getLMv2Hash(), this.challenge, getClientChallenge());
            }
            return this.lmv2Response;
        }

        public byte[] getLanManagerSessionKey() throws NTLMEngineException {
            String str = "DES/ECB/NoPadding";
            if (this.lanManagerSessionKey == null) {
                try {
                    byte[] bArr = new byte[14];
                    System.arraycopy(getLMHash(), 0, bArr, 0, 8);
                    Arrays.fill(bArr, 8, 14, -67);
                    Key access$900 = NTLMEngineImpl.createDESKey(bArr, 0);
                    Key access$9002 = NTLMEngineImpl.createDESKey(bArr, 7);
                    byte[] bArr2 = new byte[8];
                    System.arraycopy(getLMResponse(), 0, bArr2, 0, 8);
                    Cipher instance = Cipher.getInstance(str);
                    instance.init(1, access$900);
                    byte[] doFinal = instance.doFinal(bArr2);
                    Cipher instance2 = Cipher.getInstance(str);
                    instance2.init(1, access$9002);
                    byte[] doFinal2 = instance2.doFinal(bArr2);
                    byte[] bArr3 = new byte[16];
                    this.lanManagerSessionKey = bArr3;
                    System.arraycopy(doFinal, 0, bArr3, 0, doFinal.length);
                    System.arraycopy(doFinal2, 0, this.lanManagerSessionKey, doFinal.length, doFinal2.length);
                } catch (Exception e2) {
                    throw new NTLMEngineException(e2.getMessage(), e2);
                }
            }
            return this.lanManagerSessionKey;
        }

        public byte[] getNTLM2SessionResponse() throws NTLMEngineException {
            if (this.ntlm2SessionResponse == null) {
                this.ntlm2SessionResponse = NTLMEngineImpl.ntlm2SessionResponse(getNTLMHash(), this.challenge, getClientChallenge());
            }
            return this.ntlm2SessionResponse;
        }

        public byte[] getNTLM2SessionResponseUserSessionKey() throws NTLMEngineException {
            if (this.ntlm2SessionResponseUserSessionKey == null) {
                byte[] lM2SessionResponse = getLM2SessionResponse();
                byte[] bArr = this.challenge;
                byte[] bArr2 = new byte[(bArr.length + lM2SessionResponse.length)];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                System.arraycopy(lM2SessionResponse, 0, bArr2, this.challenge.length, lM2SessionResponse.length);
                this.ntlm2SessionResponseUserSessionKey = NTLMEngineImpl.hmacMD5(bArr2, getNTLMUserSessionKey());
            }
            return this.ntlm2SessionResponseUserSessionKey;
        }

        public byte[] getNTLMHash() throws NTLMEngineException {
            if (this.ntlmHash == null) {
                this.ntlmHash = NTLMEngineImpl.ntlmHash(this.password);
            }
            return this.ntlmHash;
        }

        public byte[] getNTLMResponse() throws NTLMEngineException {
            if (this.ntlmResponse == null) {
                this.ntlmResponse = NTLMEngineImpl.lmResponse(getNTLMHash(), this.challenge);
            }
            return this.ntlmResponse;
        }

        public byte[] getNTLMUserSessionKey() throws NTLMEngineException {
            if (this.ntlmUserSessionKey == null) {
                MD4 md4 = new MD4();
                md4.update(getNTLMHash());
                this.ntlmUserSessionKey = md4.getOutput();
            }
            return this.ntlmUserSessionKey;
        }

        public byte[] getNTLMv2Blob() throws NTLMEngineException {
            if (this.ntlmv2Blob == null) {
                this.ntlmv2Blob = NTLMEngineImpl.createBlob(getClientChallenge2(), this.targetInformation, getTimestamp());
            }
            return this.ntlmv2Blob;
        }

        public byte[] getNTLMv2Hash() throws NTLMEngineException {
            if (this.ntlmv2Hash == null) {
                this.ntlmv2Hash = NTLMEngineImpl.ntlmv2Hash(this.domain, this.user, getNTLMHash());
            }
            return this.ntlmv2Hash;
        }

        public byte[] getNTLMv2Response() throws NTLMEngineException {
            if (this.ntlmv2Response == null) {
                this.ntlmv2Response = NTLMEngineImpl.lmv2Response(getNTLMv2Hash(), this.challenge, getNTLMv2Blob());
            }
            return this.ntlmv2Response;
        }

        public byte[] getNTLMv2UserSessionKey() throws NTLMEngineException {
            if (this.ntlmv2UserSessionKey == null) {
                byte[] nTLMv2Hash = getNTLMv2Hash();
                byte[] bArr = new byte[16];
                System.arraycopy(getNTLMv2Response(), 0, bArr, 0, 16);
                this.ntlmv2UserSessionKey = NTLMEngineImpl.hmacMD5(bArr, nTLMv2Hash);
            }
            return this.ntlmv2UserSessionKey;
        }

        public byte[] getSecondaryKey() throws NTLMEngineException {
            if (this.secondaryKey == null) {
                this.secondaryKey = NTLMEngineImpl.makeSecondaryKey();
            }
            return this.secondaryKey;
        }

        public byte[] getTimestamp() {
            if (this.timestamp == null) {
                long currentTimeMillis = (System.currentTimeMillis() + 11644473600000L) * FragmentStateAdapter.GRACE_WINDOW_TIME_MS;
                this.timestamp = new byte[8];
                for (int i2 = 0; i2 < 8; i2++) {
                    this.timestamp[i2] = (byte) ((int) currentTimeMillis);
                    currentTimeMillis >>>= 8;
                }
            }
            return this.timestamp;
        }

        public CipherGen(String str, String str2, String str3, byte[] bArr, String str4, byte[] bArr2) {
            this(str, str2, str3, bArr, str4, bArr2, null, null, null, null);
        }
    }

    public static class HMACMD5 {
        public byte[] ipad;
        public MessageDigest md5;
        public byte[] opad;

        public HMACMD5(byte[] bArr) throws NTLMEngineException {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                this.md5 = instance;
                this.ipad = new byte[64];
                this.opad = new byte[64];
                int length = bArr.length;
                if (length > 64) {
                    instance.update(bArr);
                    bArr = this.md5.digest();
                    length = bArr.length;
                }
                int i2 = 0;
                while (i2 < length) {
                    this.ipad[i2] = (byte) (54 ^ bArr[i2]);
                    this.opad[i2] = (byte) (92 ^ bArr[i2]);
                    i2++;
                }
                while (i2 < 64) {
                    this.ipad[i2] = 54;
                    this.opad[i2] = 92;
                    i2++;
                }
                this.md5.reset();
                this.md5.update(this.ipad);
            } catch (Exception e2) {
                StringBuilder a2 = a.a("Error getting md5 message digest implementation: ");
                a2.append(e2.getMessage());
                throw new NTLMEngineException(a2.toString(), e2);
            }
        }

        public byte[] getOutput() {
            byte[] digest = this.md5.digest();
            this.md5.update(this.opad);
            return this.md5.digest(digest);
        }

        public void update(byte[] bArr) {
            this.md5.update(bArr);
        }

        public void update(byte[] bArr, int i2, int i3) {
            this.md5.update(bArr, i2, i3);
        }
    }

    public static class MD4 {
        public int A = 1732584193;
        public int B = -271733879;
        public int C = -1732584194;
        public int D = 271733878;
        public long count = 0;
        public byte[] dataBuffer = new byte[64];

        public byte[] getOutput() {
            int i2 = (int) (this.count & 63);
            int i3 = i2 < 56 ? 56 - i2 : 120 - i2;
            byte[] bArr = new byte[(i3 + 8)];
            bArr[0] = Byte.MIN_VALUE;
            for (int i4 = 0; i4 < 8; i4++) {
                bArr[i3 + i4] = (byte) ((int) ((this.count * 8) >>> (i4 * 8)));
            }
            update(bArr);
            byte[] bArr2 = new byte[16];
            NTLMEngineImpl.writeULong(bArr2, this.A, 0);
            NTLMEngineImpl.writeULong(bArr2, this.B, 4);
            NTLMEngineImpl.writeULong(bArr2, this.C, 8);
            NTLMEngineImpl.writeULong(bArr2, this.D, 12);
            return bArr2;
        }

        public void processBuffer() {
            int[] iArr = new int[16];
            for (int i2 = 0; i2 < 16; i2++) {
                byte[] bArr = this.dataBuffer;
                int i3 = i2 * 4;
                iArr[i2] = (bArr[i3] & 255) + ((bArr[i3 + 1] & 255) << 8) + ((bArr[i3 + 2] & 255) << 16) + ((bArr[i3 + 3] & 255) << 24);
            }
            int i4 = this.A;
            int i5 = this.B;
            int i6 = this.C;
            int i7 = this.D;
            round1(iArr);
            round2(iArr);
            round3(iArr);
            this.A += i4;
            this.B += i5;
            this.C += i6;
            this.D += i7;
        }

        public void round1(int[] iArr) {
            int rotintlft = NTLMEngineImpl.rotintlft(NTLMEngineImpl.F(this.B, this.C, this.D) + this.A + iArr[0], 3);
            this.A = rotintlft;
            int rotintlft2 = NTLMEngineImpl.rotintlft(NTLMEngineImpl.F(rotintlft, this.B, this.C) + this.D + iArr[1], 7);
            this.D = rotintlft2;
            int rotintlft3 = NTLMEngineImpl.rotintlft(NTLMEngineImpl.F(rotintlft2, this.A, this.B) + this.C + iArr[2], 11);
            this.C = rotintlft3;
            int rotintlft4 = NTLMEngineImpl.rotintlft(NTLMEngineImpl.F(rotintlft3, this.D, this.A) + this.B + iArr[3], 19);
            this.B = rotintlft4;
            int rotintlft5 = NTLMEngineImpl.rotintlft(NTLMEngineImpl.F(rotintlft4, this.C, this.D) + this.A + iArr[4], 3);
            this.A = rotintlft5;
            int rotintlft6 = NTLMEngineImpl.rotintlft(NTLMEngineImpl.F(rotintlft5, this.B, this.C) + this.D + iArr[5], 7);
            this.D = rotintlft6;
            int rotintlft7 = NTLMEngineImpl.rotintlft(NTLMEngineImpl.F(rotintlft6, this.A, this.B) + this.C + iArr[6], 11);
            this.C = rotintlft7;
            int rotintlft8 = NTLMEngineImpl.rotintlft(NTLMEngineImpl.F(rotintlft7, this.D, this.A) + this.B + iArr[7], 19);
            this.B = rotintlft8;
            int rotintlft9 = NTLMEngineImpl.rotintlft(NTLMEngineImpl.F(rotintlft8, this.C, this.D) + this.A + iArr[8], 3);
            this.A = rotintlft9;
            int rotintlft10 = NTLMEngineImpl.rotintlft(NTLMEngineImpl.F(rotintlft9, this.B, this.C) + this.D + iArr[9], 7);
            this.D = rotintlft10;
            int rotintlft11 = NTLMEngineImpl.rotintlft(NTLMEngineImpl.F(rotintlft10, this.A, this.B) + this.C + iArr[10], 11);
            this.C = rotintlft11;
            int rotintlft12 = NTLMEngineImpl.rotintlft(NTLMEngineImpl.F(rotintlft11, this.D, this.A) + this.B + iArr[11], 19);
            this.B = rotintlft12;
            int rotintlft13 = NTLMEngineImpl.rotintlft(NTLMEngineImpl.F(rotintlft12, this.C, this.D) + this.A + iArr[12], 3);
            this.A = rotintlft13;
            int rotintlft14 = NTLMEngineImpl.rotintlft(NTLMEngineImpl.F(rotintlft13, this.B, this.C) + this.D + iArr[13], 7);
            this.D = rotintlft14;
            int rotintlft15 = NTLMEngineImpl.rotintlft(NTLMEngineImpl.F(rotintlft14, this.A, this.B) + this.C + iArr[14], 11);
            this.C = rotintlft15;
            this.B = NTLMEngineImpl.rotintlft(NTLMEngineImpl.F(rotintlft15, this.D, this.A) + this.B + iArr[15], 19);
        }

        public void round2(int[] iArr) {
            int a2 = a.a(NTLMEngineImpl.G(this.B, this.C, this.D) + this.A, iArr[0], 1518500249, 3);
            this.A = a2;
            int a3 = a.a(NTLMEngineImpl.G(a2, this.B, this.C) + this.D, iArr[4], 1518500249, 5);
            this.D = a3;
            int a4 = a.a(NTLMEngineImpl.G(a3, this.A, this.B) + this.C, iArr[8], 1518500249, 9);
            this.C = a4;
            int a5 = a.a(NTLMEngineImpl.G(a4, this.D, this.A) + this.B, iArr[12], 1518500249, 13);
            this.B = a5;
            int a6 = a.a(NTLMEngineImpl.G(a5, this.C, this.D) + this.A, iArr[1], 1518500249, 3);
            this.A = a6;
            int a7 = a.a(NTLMEngineImpl.G(a6, this.B, this.C) + this.D, iArr[5], 1518500249, 5);
            this.D = a7;
            int a8 = a.a(NTLMEngineImpl.G(a7, this.A, this.B) + this.C, iArr[9], 1518500249, 9);
            this.C = a8;
            int a9 = a.a(NTLMEngineImpl.G(a8, this.D, this.A) + this.B, iArr[13], 1518500249, 13);
            this.B = a9;
            int a10 = a.a(NTLMEngineImpl.G(a9, this.C, this.D) + this.A, iArr[2], 1518500249, 3);
            this.A = a10;
            int a11 = a.a(NTLMEngineImpl.G(a10, this.B, this.C) + this.D, iArr[6], 1518500249, 5);
            this.D = a11;
            int a12 = a.a(NTLMEngineImpl.G(a11, this.A, this.B) + this.C, iArr[10], 1518500249, 9);
            this.C = a12;
            int a13 = a.a(NTLMEngineImpl.G(a12, this.D, this.A) + this.B, iArr[14], 1518500249, 13);
            this.B = a13;
            int a14 = a.a(NTLMEngineImpl.G(a13, this.C, this.D) + this.A, iArr[3], 1518500249, 3);
            this.A = a14;
            int a15 = a.a(NTLMEngineImpl.G(a14, this.B, this.C) + this.D, iArr[7], 1518500249, 5);
            this.D = a15;
            int a16 = a.a(NTLMEngineImpl.G(a15, this.A, this.B) + this.C, iArr[11], 1518500249, 9);
            this.C = a16;
            this.B = a.a(NTLMEngineImpl.G(a16, this.D, this.A) + this.B, iArr[15], 1518500249, 13);
        }

        public void round3(int[] iArr) {
            int a2 = a.a(NTLMEngineImpl.H(this.B, this.C, this.D) + this.A, iArr[0], 1859775393, 3);
            this.A = a2;
            int a3 = a.a(NTLMEngineImpl.H(a2, this.B, this.C) + this.D, iArr[8], 1859775393, 9);
            this.D = a3;
            int a4 = a.a(NTLMEngineImpl.H(a3, this.A, this.B) + this.C, iArr[4], 1859775393, 11);
            this.C = a4;
            int a5 = a.a(NTLMEngineImpl.H(a4, this.D, this.A) + this.B, iArr[12], 1859775393, 15);
            this.B = a5;
            int a6 = a.a(NTLMEngineImpl.H(a5, this.C, this.D) + this.A, iArr[2], 1859775393, 3);
            this.A = a6;
            int a7 = a.a(NTLMEngineImpl.H(a6, this.B, this.C) + this.D, iArr[10], 1859775393, 9);
            this.D = a7;
            int a8 = a.a(NTLMEngineImpl.H(a7, this.A, this.B) + this.C, iArr[6], 1859775393, 11);
            this.C = a8;
            int a9 = a.a(NTLMEngineImpl.H(a8, this.D, this.A) + this.B, iArr[14], 1859775393, 15);
            this.B = a9;
            int a10 = a.a(NTLMEngineImpl.H(a9, this.C, this.D) + this.A, iArr[1], 1859775393, 3);
            this.A = a10;
            int a11 = a.a(NTLMEngineImpl.H(a10, this.B, this.C) + this.D, iArr[9], 1859775393, 9);
            this.D = a11;
            int a12 = a.a(NTLMEngineImpl.H(a11, this.A, this.B) + this.C, iArr[5], 1859775393, 11);
            this.C = a12;
            int a13 = a.a(NTLMEngineImpl.H(a12, this.D, this.A) + this.B, iArr[13], 1859775393, 15);
            this.B = a13;
            int a14 = a.a(NTLMEngineImpl.H(a13, this.C, this.D) + this.A, iArr[3], 1859775393, 3);
            this.A = a14;
            int a15 = a.a(NTLMEngineImpl.H(a14, this.B, this.C) + this.D, iArr[11], 1859775393, 9);
            this.D = a15;
            int a16 = a.a(NTLMEngineImpl.H(a15, this.A, this.B) + this.C, iArr[7], 1859775393, 11);
            this.C = a16;
            this.B = a.a(NTLMEngineImpl.H(a16, this.D, this.A) + this.B, iArr[15], 1859775393, 15);
        }

        public void update(byte[] bArr) {
            byte[] bArr2;
            int i2 = (int) (this.count & 63);
            int i3 = 0;
            while (true) {
                int length = (bArr.length - i3) + i2;
                bArr2 = this.dataBuffer;
                if (length < bArr2.length) {
                    break;
                }
                int length2 = bArr2.length - i2;
                System.arraycopy(bArr, i3, bArr2, i2, length2);
                this.count += (long) length2;
                i3 += length2;
                processBuffer();
                i2 = 0;
            }
            if (i3 < bArr.length) {
                int length3 = bArr.length - i3;
                System.arraycopy(bArr, i3, bArr2, i2, length3);
                this.count += (long) length3;
            }
        }
    }

    public static class NTLMEngineException extends Exception {
        public NTLMEngineException(String str) {
            super(str);
        }

        public NTLMEngineException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static class NTLMMessage {
        public int currentOutputPosition;
        public byte[] messageContents;

        public NTLMMessage() {
            this.messageContents = null;
            this.currentOutputPosition = 0;
        }

        public void addByte(byte b2) {
            byte[] bArr = this.messageContents;
            int i2 = this.currentOutputPosition;
            bArr[i2] = b2;
            this.currentOutputPosition = i2 + 1;
        }

        public void addBytes(byte[] bArr) {
            if (bArr != null) {
                for (byte b2 : bArr) {
                    byte[] bArr2 = this.messageContents;
                    int i2 = this.currentOutputPosition;
                    bArr2[i2] = b2;
                    this.currentOutputPosition = i2 + 1;
                }
            }
        }

        public void addULong(int i2) {
            addByte((byte) (i2 & 255));
            addByte((byte) ((i2 >> 8) & 255));
            addByte((byte) ((i2 >> 16) & 255));
            addByte((byte) ((i2 >> 24) & 255));
        }

        public void addUShort(int i2) {
            addByte((byte) (i2 & 255));
            addByte((byte) ((i2 >> 8) & 255));
        }

        public int getMessageLength() {
            return this.currentOutputPosition;
        }

        public int getPreambleLength() {
            return NTLMEngineImpl.SIGNATURE.length + 4;
        }

        public String getResponse() {
            byte[] bArr = this.messageContents;
            int length = bArr.length;
            int i2 = this.currentOutputPosition;
            if (length > i2) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                bArr = bArr2;
            }
            return Base64.encodeToString(bArr, 2);
        }

        public void prepareResponse(int i2, int i3) {
            this.messageContents = new byte[i2];
            this.currentOutputPosition = 0;
            addBytes(NTLMEngineImpl.SIGNATURE);
            addULong(i3);
        }

        public byte readByte(int i2) throws NTLMEngineException {
            byte[] bArr = this.messageContents;
            if (bArr.length >= i2 + 1) {
                return bArr[i2];
            }
            throw new NTLMEngineException("NTLM: Message too short");
        }

        public void readBytes(byte[] bArr, int i2) throws NTLMEngineException {
            byte[] bArr2 = this.messageContents;
            if (bArr2.length >= bArr.length + i2) {
                System.arraycopy(bArr2, i2, bArr, 0, bArr.length);
                return;
            }
            throw new NTLMEngineException("NTLM: Message too short");
        }

        public byte[] readSecurityBuffer(int i2) throws NTLMEngineException {
            return NTLMEngineImpl.readSecurityBuffer(this.messageContents, i2);
        }

        public int readULong(int i2) throws NTLMEngineException {
            return NTLMEngineImpl.readULong(this.messageContents, i2);
        }

        public int readUShort(int i2) throws NTLMEngineException {
            return NTLMEngineImpl.readUShort(this.messageContents, i2);
        }

        public NTLMMessage(String str, int i2) throws NTLMEngineException {
            this.messageContents = null;
            int i3 = 0;
            this.currentOutputPosition = 0;
            byte[] decode = Base64.decode(str.getBytes(NTLMEngineImpl.DEFAULT_CHARSET), 2);
            this.messageContents = decode;
            if (decode.length >= NTLMEngineImpl.SIGNATURE.length) {
                while (i3 < NTLMEngineImpl.SIGNATURE.length) {
                    if (this.messageContents[i3] == NTLMEngineImpl.SIGNATURE[i3]) {
                        i3++;
                    } else {
                        throw new NTLMEngineException("NTLM message expected - instead got unrecognized bytes");
                    }
                }
                int readULong = readULong(NTLMEngineImpl.SIGNATURE.length);
                if (readULong == i2) {
                    this.currentOutputPosition = this.messageContents.length;
                    return;
                }
                StringBuilder a2 = a.a("NTLM type ");
                a2.append(Integer.toString(i2));
                a2.append(" message expected - instead got type ");
                a2.append(Integer.toString(readULong));
                throw new NTLMEngineException(a2.toString());
            }
            throw new NTLMEngineException("NTLM message decoding error - packet too short");
        }
    }

    public static class Type1Message extends NTLMMessage {
        public final byte[] domainBytes;
        public final byte[] hostBytes;

        public Type1Message(String str, String str2) throws NTLMEngineException {
            if (NTLMEngineImpl.UNICODE_LITTLE_UNMARKED != null) {
                String access$1600 = NTLMEngineImpl.convertHost(str2);
                String access$1700 = NTLMEngineImpl.convertDomain(str);
                byte[] bArr = null;
                this.hostBytes = access$1600 != null ? access$1600.getBytes(NTLMEngineImpl.UNICODE_LITTLE_UNMARKED) : null;
                if (access$1700 != null) {
                    bArr = access$1700.toUpperCase(Locale.ROOT).getBytes(NTLMEngineImpl.UNICODE_LITTLE_UNMARKED);
                }
                this.domainBytes = bArr;
                return;
            }
            throw new NTLMEngineException("Unicode not supported");
        }

        public String getResponse() {
            prepareResponse(40, 1);
            addULong(-1576500735);
            addUShort(0);
            addUShort(0);
            addULong(40);
            addUShort(0);
            addUShort(0);
            addULong(40);
            addUShort(261);
            addULong(2600);
            addUShort(3840);
            byte[] bArr = this.hostBytes;
            if (bArr != null) {
                addBytes(bArr);
            }
            byte[] bArr2 = this.domainBytes;
            if (bArr2 != null) {
                addBytes(bArr2);
            }
            return super.getResponse();
        }

        public Type1Message() {
            this.hostBytes = null;
            this.domainBytes = null;
        }
    }

    public static class Type2Message extends NTLMMessage {
        public byte[] challenge;
        public int flags;
        public String target;
        public byte[] targetInfo;

        public Type2Message(String str) throws NTLMEngineException {
            super(str, 2);
            byte[] bArr = new byte[8];
            this.challenge = bArr;
            readBytes(bArr, 24);
            int readULong = readULong(20);
            this.flags = readULong;
            if ((readULong & 1) != 0) {
                this.target = null;
                if (getMessageLength() >= 20) {
                    byte[] readSecurityBuffer = readSecurityBuffer(12);
                    if (readSecurityBuffer.length != 0) {
                        try {
                            this.target = new String(readSecurityBuffer, "UnicodeLittleUnmarked");
                        } catch (UnsupportedEncodingException e2) {
                            throw new NTLMEngineException(e2.getMessage(), e2);
                        }
                    }
                }
                this.targetInfo = null;
                if (getMessageLength() >= 48) {
                    byte[] readSecurityBuffer2 = readSecurityBuffer(40);
                    if (readSecurityBuffer2.length != 0) {
                        this.targetInfo = readSecurityBuffer2;
                        return;
                    }
                    return;
                }
                return;
            }
            StringBuilder a2 = a.a("NTLM type 2 message indicates no support for Unicode. Flags are: ");
            a2.append(Integer.toString(this.flags));
            throw new NTLMEngineException(a2.toString());
        }

        public byte[] getChallenge() {
            return this.challenge;
        }

        public int getFlags() {
            return this.flags;
        }

        public String getTarget() {
            return this.target;
        }

        public byte[] getTargetInfo() {
            return this.targetInfo;
        }
    }

    public static class Type3Message extends NTLMMessage {
        public byte[] domainBytes;
        public byte[] hostBytes;
        public byte[] lmResp;
        public byte[] ntResp;
        public byte[] sessionKey;
        public int type2Flags;
        public byte[] userBytes;

        public Type3Message(String str, String str2, String str3, String str4, byte[] bArr, int i2, String str5, byte[] bArr2) throws NTLMEngineException {
            byte[] bArr3;
            int i3 = i2;
            this.type2Flags = i3;
            String access$1600 = NTLMEngineImpl.convertHost(str2);
            String access$1700 = NTLMEngineImpl.convertDomain(str);
            CipherGen cipherGen = new CipherGen(access$1700, str3, str4, bArr, str5, bArr2);
            if ((8388608 & i3) != 0 && bArr2 != null && str5 != null) {
                try {
                    this.ntResp = cipherGen.getNTLMv2Response();
                    this.lmResp = cipherGen.getLMv2Response();
                    if ((i3 & 128) != 0) {
                        bArr3 = cipherGen.getLanManagerSessionKey();
                    } else {
                        bArr3 = cipherGen.getNTLMv2UserSessionKey();
                    }
                } catch (NTLMEngineException unused) {
                    this.ntResp = new byte[0];
                    this.lmResp = cipherGen.getLMResponse();
                    if ((i3 & 128) != 0) {
                        bArr3 = cipherGen.getLanManagerSessionKey();
                    } else {
                        bArr3 = cipherGen.getLMUserSessionKey();
                    }
                }
            } else if ((524288 & i3) != 0) {
                this.ntResp = cipherGen.getNTLM2SessionResponse();
                this.lmResp = cipherGen.getLM2SessionResponse();
                if ((i3 & 128) != 0) {
                    bArr3 = cipherGen.getLanManagerSessionKey();
                } else {
                    bArr3 = cipherGen.getNTLM2SessionResponseUserSessionKey();
                }
            } else {
                this.ntResp = cipherGen.getNTLMResponse();
                this.lmResp = cipherGen.getLMResponse();
                if ((i3 & 128) != 0) {
                    bArr3 = cipherGen.getLanManagerSessionKey();
                } else {
                    bArr3 = cipherGen.getNTLMUserSessionKey();
                }
            }
            byte[] bArr4 = null;
            if ((i3 & 16) == 0) {
                this.sessionKey = null;
            } else if ((i3 & NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH) != 0) {
                this.sessionKey = NTLMEngineImpl.RC4(cipherGen.getSecondaryKey(), bArr3);
            } else {
                this.sessionKey = bArr3;
            }
            if (NTLMEngineImpl.UNICODE_LITTLE_UNMARKED != null) {
                this.hostBytes = access$1600 != null ? access$1600.getBytes(NTLMEngineImpl.UNICODE_LITTLE_UNMARKED) : null;
                if (access$1700 != null) {
                    bArr4 = access$1700.toUpperCase(Locale.ROOT).getBytes(NTLMEngineImpl.UNICODE_LITTLE_UNMARKED);
                }
                this.domainBytes = bArr4;
                String str6 = str3;
                this.userBytes = str3.getBytes(NTLMEngineImpl.UNICODE_LITTLE_UNMARKED);
                return;
            }
            throw new NTLMEngineException("Unicode not supported");
        }

        public String getResponse() {
            int length = this.ntResp.length;
            int length2 = this.lmResp.length;
            byte[] bArr = this.domainBytes;
            int i2 = 0;
            int length3 = bArr != null ? bArr.length : 0;
            byte[] bArr2 = this.hostBytes;
            int length4 = bArr2 != null ? bArr2.length : 0;
            int length5 = this.userBytes.length;
            byte[] bArr3 = this.sessionKey;
            if (bArr3 != null) {
                i2 = bArr3.length;
            }
            int i3 = length2 + 72;
            int i4 = i3 + length;
            int i5 = i4 + length3;
            int i6 = i5 + length5;
            int i7 = i6 + length4;
            prepareResponse(i7 + i2, 3);
            addUShort(length2);
            addUShort(length2);
            addULong(72);
            addUShort(length);
            addUShort(length);
            addULong(i3);
            addUShort(length3);
            addUShort(length3);
            addULong(i4);
            addUShort(length5);
            addUShort(length5);
            addULong(i5);
            addUShort(length4);
            addUShort(length4);
            addULong(i6);
            addUShort(i2);
            addUShort(i2);
            addULong(i7);
            int i8 = this.type2Flags;
            addULong((i8 & 4) | (i8 & 128) | (i8 & 512) | (524288 & i8) | NTLMEngineImpl.FLAG_REQUEST_VERSION | (32768 & i8) | (i8 & 32) | (i8 & 16) | (536870912 & i8) | (Integer.MIN_VALUE & i8) | (1073741824 & i8) | (8388608 & i8) | (i8 & 1));
            addUShort(261);
            addULong(2600);
            addUShort(3840);
            addBytes(this.lmResp);
            addBytes(this.ntResp);
            addBytes(this.domainBytes);
            addBytes(this.userBytes);
            addBytes(this.hostBytes);
            byte[] bArr4 = this.sessionKey;
            if (bArr4 != null) {
                addBytes(bArr4);
            }
            return super.getResponse();
        }
    }

    static {
        SecureRandom secureRandom;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception unused) {
            secureRandom = null;
        }
        RND_GEN = secureRandom;
        byte[] bytes = "NTLMSSP".getBytes(DEFAULT_CHARSET);
        byte[] bArr = new byte[(bytes.length + 1)];
        SIGNATURE = bArr;
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        SIGNATURE[bytes.length] = 0;
    }

    public static int F(int i2, int i3, int i4) {
        return ((~i2) & i4) | (i3 & i2);
    }

    public static int G(int i2, int i3, int i4) {
        return (i2 & i4) | (i2 & i3) | (i3 & i4);
    }

    public static int H(int i2, int i3, int i4) {
        return (i2 ^ i3) ^ i4;
    }

    public static byte[] RC4(byte[] bArr, byte[] bArr2) throws NTLMEngineException {
        String str = "RC4";
        try {
            Cipher instance = Cipher.getInstance(str);
            instance.init(1, new SecretKeySpec(bArr2, str));
            return instance.doFinal(bArr);
        } catch (Exception e2) {
            throw new NTLMEngineException(e2.getMessage(), e2);
        }
    }

    public static String convertDomain(String str) {
        return stripDotSuffix(str);
    }

    public static String convertHost(String str) {
        return stripDotSuffix(str);
    }

    public static byte[] createBlob(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = {0, 0, 0, 0};
        byte[] bArr5 = {0, 0, 0, 0};
        byte[] bArr6 = {0, 0, 0, 0};
        byte[] bArr7 = new byte[(bArr3.length + 8 + 8 + 4 + bArr2.length + 4)];
        System.arraycopy(new byte[]{1, 1, 0, 0}, 0, bArr7, 0, 4);
        System.arraycopy(bArr4, 0, bArr7, 4, 4);
        System.arraycopy(bArr3, 0, bArr7, 8, bArr3.length);
        int length = bArr3.length + 8;
        System.arraycopy(bArr, 0, bArr7, length, 8);
        int i2 = length + 8;
        System.arraycopy(bArr5, 0, bArr7, i2, 4);
        int i3 = i2 + 4;
        System.arraycopy(bArr2, 0, bArr7, i3, bArr2.length);
        System.arraycopy(bArr6, 0, bArr7, i3 + bArr2.length, 4);
        return bArr7;
    }

    public static Key createDESKey(byte[] bArr, int i2) {
        byte[] bArr2 = new byte[7];
        System.arraycopy(bArr, i2, bArr2, 0, 7);
        byte[] bArr3 = {bArr2[0], (byte) ((bArr2[0] << 7) | ((bArr2[1] & 255) >>> 1)), (byte) ((bArr2[1] << 6) | ((bArr2[2] & 255) >>> 2)), (byte) ((bArr2[2] << 5) | ((bArr2[3] & 255) >>> 3)), (byte) ((bArr2[3] << 4) | ((bArr2[4] & 255) >>> 4)), (byte) ((bArr2[4] << 3) | ((bArr2[5] & 255) >>> 5)), (byte) ((bArr2[5] << 2) | ((bArr2[6] & 255) >>> 6)), (byte) (bArr2[6] << 1)};
        oddParity(bArr3);
        return new SecretKeySpec(bArr3, "DES");
    }

    public static String getResponseFor(String str, String str2, String str3, String str4, String str5) throws NTLMEngineException {
        if (str == null || str.trim().equals("")) {
            return getType1Message(str4, str5);
        }
        Type2Message type2Message = new Type2Message(str);
        return getType3Message(str2, str3, str4, str5, type2Message.getChallenge(), type2Message.getFlags(), type2Message.getTarget(), type2Message.getTargetInfo());
    }

    public static String getType1Message(String str, String str2) throws NTLMEngineException {
        return TYPE_1_MESSAGE;
    }

    public static String getType3Message(String str, String str2, String str3, String str4, byte[] bArr, int i2, String str5, byte[] bArr2) throws NTLMEngineException {
        Type3Message type3Message = new Type3Message(str4, str3, str, str2, bArr, i2, str5, bArr2);
        return type3Message.getResponse();
    }

    public static byte[] hmacMD5(byte[] bArr, byte[] bArr2) throws NTLMEngineException {
        HMACMD5 hmacmd5 = new HMACMD5(bArr2);
        hmacmd5.update(bArr);
        return hmacmd5.getOutput();
    }

    public static byte[] lmHash(String str) throws NTLMEngineException {
        try {
            byte[] bytes = str.toUpperCase(Locale.ROOT).getBytes(DEFAULT_CHARSET);
            byte[] bArr = new byte[14];
            System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 14));
            Key createDESKey = createDESKey(bArr, 0);
            Key createDESKey2 = createDESKey(bArr, 7);
            byte[] bytes2 = "KGS!@#$%".getBytes(DEFAULT_CHARSET);
            Cipher instance = Cipher.getInstance("DES/ECB/NoPadding");
            instance.init(1, createDESKey);
            byte[] doFinal = instance.doFinal(bytes2);
            instance.init(1, createDESKey2);
            byte[] doFinal2 = instance.doFinal(bytes2);
            byte[] bArr2 = new byte[16];
            System.arraycopy(doFinal, 0, bArr2, 0, 8);
            System.arraycopy(doFinal2, 0, bArr2, 8, 8);
            return bArr2;
        } catch (Exception e2) {
            throw new NTLMEngineException(e2.getMessage(), e2);
        }
    }

    public static byte[] lmResponse(byte[] bArr, byte[] bArr2) throws NTLMEngineException {
        try {
            byte[] bArr3 = new byte[21];
            System.arraycopy(bArr, 0, bArr3, 0, 16);
            Key createDESKey = createDESKey(bArr3, 0);
            Key createDESKey2 = createDESKey(bArr3, 7);
            Key createDESKey3 = createDESKey(bArr3, 14);
            Cipher instance = Cipher.getInstance("DES/ECB/NoPadding");
            instance.init(1, createDESKey);
            byte[] doFinal = instance.doFinal(bArr2);
            instance.init(1, createDESKey2);
            byte[] doFinal2 = instance.doFinal(bArr2);
            instance.init(1, createDESKey3);
            byte[] doFinal3 = instance.doFinal(bArr2);
            byte[] bArr4 = new byte[24];
            System.arraycopy(doFinal, 0, bArr4, 0, 8);
            System.arraycopy(doFinal2, 0, bArr4, 8, 8);
            System.arraycopy(doFinal3, 0, bArr4, 16, 8);
            return bArr4;
        } catch (Exception e2) {
            throw new NTLMEngineException(e2.getMessage(), e2);
        }
    }

    public static byte[] lmv2Hash(String str, String str2, byte[] bArr) throws NTLMEngineException {
        if (UNICODE_LITTLE_UNMARKED != null) {
            HMACMD5 hmacmd5 = new HMACMD5(bArr);
            hmacmd5.update(str2.toUpperCase(Locale.ROOT).getBytes(UNICODE_LITTLE_UNMARKED));
            if (str != null) {
                hmacmd5.update(str.toUpperCase(Locale.ROOT).getBytes(UNICODE_LITTLE_UNMARKED));
            }
            return hmacmd5.getOutput();
        }
        throw new NTLMEngineException("Unicode not supported");
    }

    public static byte[] lmv2Response(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NTLMEngineException {
        HMACMD5 hmacmd5 = new HMACMD5(bArr);
        hmacmd5.update(bArr2);
        hmacmd5.update(bArr3);
        byte[] output = hmacmd5.getOutput();
        byte[] bArr4 = new byte[(output.length + bArr3.length)];
        System.arraycopy(output, 0, bArr4, 0, output.length);
        System.arraycopy(bArr3, 0, bArr4, output.length, bArr3.length);
        return bArr4;
    }

    public static byte[] makeRandomChallenge() throws NTLMEngineException {
        SecureRandom secureRandom = RND_GEN;
        if (secureRandom != null) {
            byte[] bArr = new byte[8];
            synchronized (secureRandom) {
                RND_GEN.nextBytes(bArr);
            }
            return bArr;
        }
        throw new NTLMEngineException("Random generator not available");
    }

    public static byte[] makeSecondaryKey() throws NTLMEngineException {
        SecureRandom secureRandom = RND_GEN;
        if (secureRandom != null) {
            byte[] bArr = new byte[16];
            synchronized (secureRandom) {
                RND_GEN.nextBytes(bArr);
            }
            return bArr;
        }
        throw new NTLMEngineException("Random generator not available");
    }

    public static byte[] ntlm2SessionResponse(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NTLMEngineException {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr2);
            instance.update(bArr3);
            byte[] digest = instance.digest();
            byte[] bArr4 = new byte[8];
            System.arraycopy(digest, 0, bArr4, 0, 8);
            return lmResponse(bArr, bArr4);
        } catch (Exception e2) {
            if (e2 instanceof NTLMEngineException) {
                throw ((NTLMEngineException) e2);
            }
            throw new NTLMEngineException(e2.getMessage(), e2);
        }
    }

    public static byte[] ntlmHash(String str) throws NTLMEngineException {
        Charset charset = UNICODE_LITTLE_UNMARKED;
        if (charset != null) {
            byte[] bytes = str.getBytes(charset);
            MD4 md4 = new MD4();
            md4.update(bytes);
            return md4.getOutput();
        }
        throw new NTLMEngineException("Unicode not supported");
    }

    public static byte[] ntlmv2Hash(String str, String str2, byte[] bArr) throws NTLMEngineException {
        if (UNICODE_LITTLE_UNMARKED != null) {
            HMACMD5 hmacmd5 = new HMACMD5(bArr);
            hmacmd5.update(str2.toUpperCase(Locale.ROOT).getBytes(UNICODE_LITTLE_UNMARKED));
            if (str != null) {
                hmacmd5.update(str.getBytes(UNICODE_LITTLE_UNMARKED));
            }
            return hmacmd5.getOutput();
        }
        throw new NTLMEngineException("Unicode not supported");
    }

    public static void oddParity(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            if ((((b2 >>> 1) ^ ((((((b2 >>> 7) ^ (b2 >>> 6)) ^ (b2 >>> 5)) ^ (b2 >>> 4)) ^ (b2 >>> 3)) ^ (b2 >>> 2))) & 1) == 0) {
                bArr[i2] = (byte) (bArr[i2] | 1);
            } else {
                bArr[i2] = (byte) (bArr[i2] & -2);
            }
        }
    }

    public static byte[] readSecurityBuffer(byte[] bArr, int i2) throws NTLMEngineException {
        int readUShort = readUShort(bArr, i2);
        int readULong = readULong(bArr, i2 + 4);
        if (bArr.length >= readULong + readUShort) {
            byte[] bArr2 = new byte[readUShort];
            System.arraycopy(bArr, readULong, bArr2, 0, readUShort);
            return bArr2;
        }
        throw new NTLMEngineException("NTLM authentication - buffer too small for data item");
    }

    public static int readULong(byte[] bArr, int i2) throws NTLMEngineException {
        if (bArr.length >= i2 + 4) {
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }
        throw new NTLMEngineException("NTLM authentication - buffer too small for DWORD");
    }

    public static int readUShort(byte[] bArr, int i2) throws NTLMEngineException {
        if (bArr.length >= i2 + 2) {
            return ((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255);
        }
        throw new NTLMEngineException("NTLM authentication - buffer too small for WORD");
    }

    public static int rotintlft(int i2, int i3) {
        return (i2 >>> (32 - i3)) | (i2 << i3);
    }

    public static String stripDotSuffix(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(".");
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        return str;
    }

    public static void writeULong(byte[] bArr, int i2, int i3) {
        bArr[i3] = (byte) (i2 & 255);
        bArr[i3 + 1] = (byte) ((i2 >> 8) & 255);
        bArr[i3 + 2] = (byte) ((i2 >> 16) & 255);
        bArr[i3 + 3] = (byte) ((i2 >> 24) & 255);
    }

    public String generateType1Msg(String str, String str2) throws NTLMEngineException {
        return getType1Message(str2, str);
    }

    public String generateType3Msg(String str, String str2, String str3, String str4, String str5) throws NTLMEngineException {
        Type2Message type2Message = new Type2Message(str5);
        return getType3Message(str, str2, str4, str3, type2Message.getChallenge(), type2Message.getFlags(), type2Message.getTarget(), type2Message.getTargetInfo());
    }
}
