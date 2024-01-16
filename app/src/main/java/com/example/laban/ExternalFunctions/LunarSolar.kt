package com.example.laban.ExternalFunctions

import java.util.Calendar
import java.util.GregorianCalendar
import java.util.Locale

//package net.tuviphongthuy.lichvannien.src;
/**
 * @author Duc, Diep
 */
object LunarSolar {
    const val PI = Math.PI
    const val chenhLechDo1Ngay = 0.968
    val CAN = arrayOf("Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh", "Tân", "Nhâm", "Quý")

    val CHI = arrayOf("Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi")

    val GIO_NGHIA = arrayOf("23-1h", "1-3h", "3-5h", "5-7h", "7-9h", "9-11h", "11-13h", "13-15h", "15-17h", "17-19h", "19-21h", "21-23h")

    val THU = arrayOf("Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy")

    val THANG_AM = arrayOf("", "GIÊNG", "HAI", "BA", "TƯ", "NĂM", "SÁU", "BẢY", "TÁM", "CHÍN", "MƯỜI", "M.MỘT", "CHẠP")

    val NGU_HANH = arrayOf("Kim", "Thủy", "Mộc", "Hỏa", "Thổ")

    val NGU_HANH_INDEX = intArrayOf(0, 0, 1, 3, 4, 2)

    val CAN_SO = intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5)

    val CHI_SO = intArrayOf(0, 0, 1, 1, 2, 2, 0, 0, 1, 1, 2, 2)

    val TIET_KHI = arrayOf(
        "Xuân Phân", "Thanh Minh", "Cốc Vũ", "Lập Hạ", "Tiểu Mãn", "Mang Chủng", "Hạ Chí", "Tiểu Thử",
        "Đại Thử", "Lập Thu", "Xử Thử", "Bạch Lộ", "Thu Phân", "Hàn Lộ", "Sương Giáng", "Lập Đông", "Tiểu Tuyết",
        "Đại Tuyết", "Đông Chí", "Tiểu Hàn", "Đại Hàn", "Lập Xuân", "Vũ Thủy", "Kinh Trập"
    )

    val TIET_KHI_NGHIA = arrayOf(
        "Giữa xuân", "Trời quang", "Mưa rào", "Đầu hè", "Lũ nhỏ", "Sao Tua Rua mọc", "Giữa hè", "Nóng nhẹ",
        "Nóng bức", "Đầu thu", "Mưa ngâu", "Nắng nhạt", "Giữa thu", "Mát mẻ", "Sương rơi", "Đầu đông", "Tuyết nhẹ",
        "Tuyết nhiều", "Giữa đông", "Chớm lạnh", "Lạnh giá", "Đầu xuân", "Mưa ẩm", "Sâu nở"
    )

    val HUONG_HY_THAN = arrayOf("Đông Bắc", "Tây Bắc", "Tây Nam", "Nam", "Đông Nam", "Đông Bắc", "Tây Bắc", "Tây Nam", "Nam", "Đông Nam")

    val HUONG_TAI_THAN = arrayOf("Đông Nam", "Đông Nam", "Đông", "Đông", "Bắc", "Nam", "Tây Nam", "Tây Nam", "Tây", "Tây Bắc")

    val GIO_HOANG_DAO = intArrayOf(8, 10, 0, 2, 4, 6, 8, 10, 0, 2, 4, 6)

    val NGAY_HOANG_DAO = arrayOf(
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(1, 1, 0, -1, 0, 1, -1, 1, 0, -1, 0, -1),
        intArrayOf(0, -1, 1, 1, 0, -1, 0, 1, -1, 1, 0, -1),
        intArrayOf(0, -1, 0, -1, 1, 1, 0, -1, 0, 1, -1, 1),
        intArrayOf(-1, 1, 0, -1, 0, -1, 1, 1, 0, -1, 0, 1),
        intArrayOf(0, 1, -1, 1, 0, -1, 0, -1, 1, 1, 0, -1),
        intArrayOf(0, -1, 0, 1, -1, 1, 0, -1, 0, -1, 1, 1),
        intArrayOf(1, 1, 0, -1, 0, 1, -1, 1, 0, -1, 0, -1),
        intArrayOf(0, -1, 1, 1, 0, -1, 0, 1, -1, 1, 0, -1),
        intArrayOf(0, -1, 0, -1, 1, 1, 0, -1, 0, 1, -1, 1),
        intArrayOf(-1, 1, 0, -1, 0, -1, 1, 1, 0, -1, 0, 1),
        intArrayOf(0, 1, -1, 1, 0, -1, 0, -1, 1, 1, 0, -1),
        intArrayOf(0, -1, 0, 1, -1, 1, 0, -1, 0, -1, 1, 1)
    )

    val TRUC = arrayOf(
        "Kiến", "Trừ", "Mãn", "Bình", "Định", "Chấp", "Phá", "Nguy", "Thành", "Thu", "Khai", "Bế"
    )
    val TRUC_NGHIA = arrayOf(
        "Tốt cho các việc thi ơn huệ, trồng cây cối. Xấu cho các việc chôn cất, đào giếng, lợp nhà.",
        "Tốt cho các việc trừ phục, cúng giải, cạo đầu. Xấu cho các việc xuất vốn, hội họp, châm chích.",
        "Tốt cho các việc xuất hành, sửa kho, dựng nhà, mở tiệm. Xấu cho các việc chôn cất, thưa kiện, xuất vốn, nhậm chức.",
        "Tốt cho các việc dời bếp, thượng lương, làm chuồng lục súc. Xấu cho các việc khai trương, xuất nhập tài vật, giá thú, động thổ.",
        "Tốt cho các việc giao dịch, buôn bán, làm chuồng lục súc, thi ơn huệ. Xấu cho các việc xuất hành, thưa kiện, châm chích, an sàng.",
        "Tốt cho các việc tạo tác, sửa giếng, thu người làm. Xấu cho các việc xuất nhập vốn liếng, khai kho, an sàng.",
        "Tốt cho các việc dỡ nhà, phá vách, ra đi. Xấu cho các việc mở cửa hàng, may mặc, sửa kho, hội họp.",
        "Tốt cho các việc cúng lễ, may mặc, từ tụng. Xấu cho các việc hội họp, châm chích, giá thú, làm chuồng lục súc, khai trương.",
        "Tốt cho các việc nhập học, giá thú, may mặc, thượng lương. Xấu cho các việc kiện tụng, mai táng, châm chích, di cư.",
        "Tốt cho các việc khai trương, lập kho vựa, giao dịch, may mặc. Xấu cho các việc an táng, giá thú, nhậm chức, xuất nhập tài vật.",
        "Tốt cho các việc làm nhà, động thổ, làm chuồng gia súc, giá thú, đào giếng. Xấu cho các việc giao dịch, châm chích, trồng tỉa.",
        "Tốt cho các việc làm cửa, thượng lương, giá thú, trị bệnh. Xấu cho các việc nhậm chức, châm chích, đào giếng, kiện thưa."
    )


    val NHI_THAP_BAT_TU = arrayOf(
        "Hư", "Nguy", "Thất", "Bích", "Khuê", "Lâu", "Vị", "Mão", "Tất", "Trủy", "Sâm", "Tỉnh", "Quỷ", "Liễu", "Tinh", "Trương",
        "Dực", "Chẩn", "Giác", "Cang", "Đê", "Phòng", "Tâm", "Vĩ", "Cơ", "Đẩu", "Ngưu", "Nữ"
    )

    val NHI_THAP_BAT_TU_NGHIA = arrayOf(
        "Không lợi cho khởi tạo",
        "Không lợi cho khởi tạo",
        "Thuận lợi cho khởi công tu tạo, hôn nhân, mai táng",
        "Tốt mọi việc",
        "Chỉ lợi cho khởi tạo. Không lợi cho chôn cất, khai mương. Lợi cho hôn nhân",
        "Thuận lợi cho khởi công, tu tạo và hôn nhân giá thú",
        "Tốt mọi việc",
        "Không lợi cho khởi công tu tạo, mai táng, hôn nhân. Không nên dỡ cửa vào ngày này",
        "Tốt mọi việc",
        "Không nên khởi công, tạo tác, mai táng",
        "Khởi công, tạo tác được an hòa. Rất tốt cho khai trương, dỡ mái. Không lợi cho hôn nhân và mai táng",
        "Khởi công, tu tạo có lợi cho tài lộc. Không nên mai táng",
        "Không nên khởi công, tạo tác và hôn nhân. Riêng mai táng thì tốt",
        "Xấu mọi việc",
        "Thuận lợi cho khởi công, tu tạo. Không lợi cho hôn nhân, cưới gả",
        "Rất thuận lợi cho việc cất táng, khai mương, hôn nhân",
        "Tối kỵ cho việc khởi công, tu tạo. Thuận cho cất táng hôn nhân",
        "Tốt mọi việc",
        "Thuận lợi cho tất cả mọi việc. Riêng mai táng xấu",
        "Xấu mọi việc",
        "Xấu mọi việc",
        "Tạo tác vượng tài, phú quý đắc lộc, mai táng hợp",
        "Xấu mọi việc",
        "Tốt mọi việc",
        "Tốt mọi việc",
        "Tốt mọi việc",
        "Xấu mọi việc",
        "Không nên làm bất cứ việc gì, nếu tiến hành thì bất lợi cho phụ nữ"
    )

    /**
     * @param dd
     * @param mm
     * @param yy
     * @return the number of days since 1 January 4713 BC (Julian calendar)
     */
    fun jdFromDate(
        dd: Int,
        mm: Int,
        yy: Int
    ): Int {
        val a = (14 - mm) / 12
        val y = yy + 4800 - a
        val m = mm + 12 * a - 3
        var jd = dd + (153 * m + 2) / 5 + 365 * y + y / 4 - y / 100 + y / 400 - 32045
        if (jd < 2299161) {
            jd = dd + (153 * m + 2) / 5 + 365 * y + y / 4 - 32083
        }
        // jd = jd - 1721425;
        return jd
    }

    /**
     * http://www.tondering.dk/claus/calendar.html Section: Is there a formula
     * for calculating the Julian day number?
     *
     * @param jd
     * - the number of days since 1 January 4713 BC (Julian calendar)
     * @return
     */
    fun jdToDate(jd: Int): IntArray {
        val a: Int
        val b: Int
        val c: Int
        if (jd > 2299160) { // After 5/10/1582, Gregorian calendar
            a = jd + 32044
            b = (4 * a + 3) / 146097
            c = a - b * 146097 / 4
        } else {
            b = 0
            c = jd + 32082
        }
        val d = (4 * c + 3) / 1461
        val e = c - 1461 * d / 4
        val m = (5 * e + 2) / 153
        val day = e - (153 * m + 2) / 5 + 1
        val month = m + 3 - 12 * (m / 10)
        val year = b * 100 + d - 4800 + m / 10
        return intArrayOf(
            day,
            month,
            year
        )
    }

    /**
     * Solar longitude in degrees Algorithm from: Astronomical Algorithms, by
     * Jean Meeus, 1998
     *
     * @param jdn
     * - number of days since noon UTC on 1 January 4713 BC
     * @return
     */
    fun SunLongitude(jdn: Double): Double {
        // return CC2K.sunLongitude(jdn);
        return SunLongitudeAA98(jdn)
    }

    fun SunLongitudeAA98(jdn: Double): Double {
        val T = (jdn - 2451545.0) / 36525 // Time in Julian centuries from
        // 2000-01-01 12:00:00 GMT
        val T2 = T * T
        val dr = PI / 180 // degree to radian
        val M = 357.52910 + 35999.05030 * T - 0.0001559 * T2 - 0.00000048 * T * T2 // mean
        // anomaly,degree
        val L0 = 280.46645 + 36000.76983 * T + 0.0003032 * T2 // mean
        // longitude,
        // degree
        var DL = (1.914600 - 0.004817 * T - 0.000014 * T2) * Math.sin(dr * M)
        DL = DL + (0.019993 - 0.000101 * T) * Math.sin(dr * 2 * M) + 0.000290 * Math.sin(dr * 3 * M)
        var L = L0 + DL // true longitude, degree
        L = L - 360 * INT(L / 360) // Normalize to (0, 360)
        return L
    }

    fun NewMoon(k: Int): Double {
        // return CC2K.newMoonTime(k);
        return NewMoonAA98(k)
    }

    /**
     * Julian day number of the kth new moon after (or before) the New Moon of
     * 1900-01-01 13:51 GMT. Accuracy: 2 minutes Algorithm from: Astronomical
     * Algorithms, by Jean Meeus, 1998
     *
     * @param k
     * @return the Julian date number (number of days since noon UTC on 1
     * January 4713 BC) of the New Moon
     */
    fun NewMoonAA98(k: Int): Double {
        val T = k / 1236.85 // Time in Julian centuries from 1900 January
        // 0.5
        val T2 = T * T
        val T3 = T2 * T
        val dr = PI / 180
        var Jd1 =
            2415020.75933 + 29.53058868 * k + 0.0001178 * T2 - 0.000000155 * T3
        Jd1 =
            Jd1 + 0.00033 * Math.sin((166.56 + 132.87 * T - 0.009173 * T2) * dr) // Mean
        // new
        // moon
        val M =
            359.2242 + 29.10535608 * k - 0.0000333 * T2 - 0.00000347 * T3 // Sun's
        // mean
        // anomaly
        val Mpr =
            306.0253 + 385.81691806 * k + 0.0107306 * T2 + 0.00001236 * T3 // Moon's
        // mean
        // anomaly
        val F =
            21.2964 + 390.67050646 * k - 0.0016528 * T2 - 0.00000239 * T3 // Moon's
        // argument
        // of
        // latitude
        var C1 =(0.1734 - 0.000393 * T) * Math.sin(M * dr) + 0.0021 * Math.sin(2 * dr * M)
        C1 = C1 - 0.4068 * Math.sin(Mpr * dr) + 0.0161 * Math.sin(dr * 2 * Mpr)
        C1 = C1 - 0.0004 * Math.sin(dr * 3 * Mpr)
        C1 = C1 + 0.0104 * Math.sin(dr * 2 * F) - 0.0051 * Math.sin(dr * (M + Mpr))
        C1 = C1 - 0.0074 * Math.sin(dr * (M - Mpr)) + 0.0004 * Math.sin(dr * (2 * F + M))
        C1 = C1 - 0.0004 * Math.sin(dr * (2 * F - M)) - 0.0006 * Math.sin(dr * (2 * F + Mpr))
        C1 = C1 + 0.0010 * Math.sin(dr * (2 * F - Mpr)) + 0.0005 * Math.sin(dr * (2 * Mpr + M))

        val deltat: Double

        deltat = if (T < -11) {
            0.001 + 0.000839 * T + 0.0002261 * T2 - 0.00000845 * T3 - 0.000000081 * T * T3
        } else {
            -0.000278 + 0.000265 * T + 0.000262 * T2
        }
        return Jd1 + C1 - deltat
    }

    fun INT(d: Double): Int {
        return Math.floor(d).toInt()
    }

    fun getSunLongitude(
        dayNumber: Int,
        timeZone: Double
    ): Double {
        return SunLongitude(dayNumber - 0.5 - timeZone / 24)
    }

    /**
     * Tính kinh độ mặt trời
     */
    fun getSunLongitudeFromDate(
        dd: Int,
        mm: Int,
        yy: Int,
        timeZone: Double
    ): Double {
        val juliusDay = jdFromDate(
            dd,
            mm,
            yy
        )
        return getSunLongitude(
            juliusDay,
            timeZone
        )
    }

    fun getNewMoonDay(
        k: Int,
        timeZone: Double
    ): Int {
        val jd = NewMoon(k)
        return INT(jd + 0.5 + timeZone / 24)
    }

    fun getLunarMonth11(
        yy: Int,
        timeZone: Double
    ): Int {
        val off = jdFromDate(
            31,
            12,
            yy
        ) - 2415021.076998695
        val k = INT(off / 29.530588853)
        var nm = getNewMoonDay(
            k,
            timeZone
        )
        val sunLong = INT(
            getSunLongitude(
                nm,
                timeZone
            ) / 30
        )
        if (sunLong >= 9) {
            nm = getNewMoonDay(
                k - 1,
                timeZone
            )
        }
        return nm
    }

    fun getLeapMonthOffset(
        a11: Int,
        timeZone: Double
    ): Int {
        val k = INT(0.5 + (a11 - 2415021.076998695) / 29.530588853)
        var last: Int // Month 11 contains point of sun longutide 3*PI/2 (December
        // solstice)
        var i = 1 // We start with the month following lunar month 11
        var arc = INT(
            getSunLongitude(
                getNewMoonDay(
                    k + i,
                    timeZone
                ),
                timeZone
            ) / 30
        )
        do {
            last = arc
            i++
            arc = INT(
                getSunLongitude(
                    getNewMoonDay(
                        k + i,
                        timeZone
                    ),
                    timeZone
                ) / 30
            )
        } while (arc != last && i < 14)
        return i - 1
    }

    fun isLeapYear(
        year: Int,
        timeZone: Double
    ): Int {
        val lunarMonth11 = getLunarMonth11(
            year,
            timeZone
        )
        val lunarDay11 = jdToDate(lunarMonth11)
        val m11 = lunarDay11[1]
        return if (m11 > 11) {
            val preLunarMonth1 = getLunarMonth11(
                year - 1,
                timeZone
            )
            val offset = lunarMonth11 - preLunarMonth1
            if (offset > 355) {
                1
            } else 0
        } else {
            val nextLunarMonth1 = getLunarMonth11(
                year + 1,
                timeZone
            )
            val offset = nextLunarMonth1 - lunarMonth11
            val leapMonthOffset = getLeapMonthOffset(
                lunarMonth11,
                timeZone
            )
            if (offset > 355 && leapMonthOffset <= 2) {
                1
            } else 0
        }
        // return 0;
    }

    fun getLeapMonth(
        yy: Int,
        timeZone: Double
    ): Int {
        if (isLeapYear(
                yy,
                timeZone
            ) == 1
        ) {
            val lunarMonth11 = getLunarMonth11(
                yy,
                timeZone
            )
            val lunarDay11 = jdToDate(lunarMonth11)
            val m11 = lunarDay11[1]
            var leapMothOffset = 0
            leapMothOffset = if (m11 > 11) {
                val preLunarMonth11 = getLunarMonth11(
                    yy - 1,
                    timeZone
                )
                getLeapMonthOffset(
                    preLunarMonth11,
                    timeZone
                )
            } else {
                //int lunarMonth11 = getLunarMonth11(yy, timeZone);
                getLeapMonthOffset(
                    lunarMonth11,
                    timeZone
                )
            }
            return if (leapMothOffset <= 2) {
                11 + leapMothOffset - 1
            } else {
                leapMothOffset - 2
            }
        }
        return 0
    }

    /**
     * @param dd
     * @param mm
     * @param yy
     * @param timeZone
     * @return array of [lunarDay, lunarMonth, lunarYear, leapOrNot]
     */
    fun convertSolar2Lunar(
        dd: Int,
        mm: Int,
        yy: Int,
        timeZone: Double
    ): IntArray {
        val lunarDay: Int
        var lunarMonth: Int
        var lunarYear: Int
        var lunarLeap: Int
        val dayNumber = jdFromDate(
            dd,
            mm,
            yy
        )
        val k = INT((dayNumber - 2415021.076998695) / 29.530588853)
        var monthStart = getNewMoonDay(
            k + 1,
            timeZone
        )
        if (monthStart > dayNumber) {
            monthStart = getNewMoonDay(
                k,
                timeZone
            )
        }
        var a11 = getLunarMonth11(
            yy,
            timeZone
        )
        var b11 = a11
        if (a11 >= monthStart) {
            lunarYear = yy
            a11 = getLunarMonth11(
                yy - 1,
                timeZone
            )
        } else {
            lunarYear = yy + 1
            b11 = getLunarMonth11(
                yy + 1,
                timeZone
            )
        }
        lunarDay = dayNumber - monthStart + 1
        val diff = INT(((monthStart - a11) / 29).toDouble())
        lunarLeap = 0
        lunarMonth = diff + 11
        if (b11 - a11 > 365) {
            val leapMonthDiff = getLeapMonthOffset(
                a11,
                timeZone
            )
            if (diff >= leapMonthDiff) {
                lunarMonth = diff + 10
                if (diff == leapMonthDiff) {
                    lunarLeap = 1
                }
            }
        }
        if (lunarMonth > 12) {
            lunarMonth = lunarMonth - 12
        }
        if (lunarMonth >= 11 && diff < 4) {
            lunarYear -= 1
        }
        return intArrayOf(
            lunarDay,
            lunarMonth,
            lunarYear,
            lunarLeap
        )
    }

    fun convertLunar2Solar(
        lunarDay: Int,
        lunarMonth: Int,
        lunarYear: Int,
        lunarLeap: Int,
        timeZone: Double
    ): IntArray {
        val a11: Int
        val b11: Int
        if (lunarMonth < 11) {
            a11 = getLunarMonth11(
                lunarYear - 1,
                timeZone
            )
            b11 = getLunarMonth11(
                lunarYear,
                timeZone
            )
        } else {
            a11 = getLunarMonth11(
                lunarYear,
                timeZone
            )
            b11 = getLunarMonth11(
                lunarYear + 1,
                timeZone
            )
        }
        val k = INT(0.5 + (a11 - 2415021.076998695) / 29.530588853)
        var off = lunarMonth - 11
        if (off < 0) {
            off += 12
        }
        if (b11 - a11 > 365) {
            val leapOff = getLeapMonthOffset(
                a11,
                timeZone
            )
            var leapMonth = leapOff - 2
            if (leapMonth < 0) {
                leapMonth += 12
            }
            if (lunarLeap != 0 && lunarMonth != leapMonth) {
                println("Invalid input!")
                return intArrayOf(
                    0,
                    0,
                    0
                )
            } else if (lunarLeap != 0 || off >= leapOff) {
                off += 1
            }
        }
        val monthStart = getNewMoonDay(
            k + off,
            timeZone
        )
        return jdToDate(monthStart + lunarDay - 1)
    }

    fun getLunarDaysOfMonth(
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): Int {
        val solar = convertLunar2Solar(
            30,
            mm,
            yy,
            leap,
            timeZone
        )
        val solarDay = solar[0]
        val solarMonth = solar[1]
        val solarYear = solar[2]
        val lunar = convertSolar2Lunar(
            solarDay,
            solarMonth,
            solarYear,
            timeZone
        )
        val lunarDay = lunar[0]
        return if (lunarDay == 30) {
            30
        } else 29
    }

    fun getLunarYearName(yy: Int): String {

        // Để tính Can của năm Y, tìm số dư của Y+6 chia cho 10. Số dư 0 là
        // Giáp, 1 là Ất v.v. Để tính Chi của năm, chia Y+8 cho 12. Số dư 0 là
        // Tý, 1 là Sửu, 2 là Dần v.v.
        val canNumber = (yy + 6) % 10
        val chiNumber = (yy + 8) % 12
        val can = CAN[canNumber]
        val chi = CHI[chiNumber]
        var result = ""
        result = "$result$can $chi"
        return result
    }

    fun getLuoiDauKiemName(
        hh: Double,
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): String {
        val chiNumber = INT(hh + 1) % 24 / 2
        val solar = convertLunar2Solar(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        val canDayNumber = INT((dayNumber + 9).toDouble()) % 10
        val tyCan = canDayNumber % 5 * 2
        val canHourNumber = (tyCan + chiNumber) % 10
        val canHour = CAN[canHourNumber]
        val canNumber = (yy + 6) % 10
        val canYear = CAN[canNumber]
        var result = ""
        result = "$result$canYear $canHour"
        return result
    }

    fun getLunarMonthName(
        mm: Int,
        yy: Int,
        leap: Int
    ): String {
        // Trong một năm âm lịch, tháng 11 là tháng Tý, tháng 12 là Sửu, tháng
        // Giêng là tháng Dần v.v. Can của tháng M năm Y âm lịch được tính theo
        // công thức sau: chia Y*12+M+3 cho 10. Số dư 0 là Giáp, 1 là Ất v.v.
        val canNumber = (yy * 12 + mm + 3) % 10
        val chiNumber = (mm + 1) % 12
        val can = CAN[canNumber]
        val chi = CHI[chiNumber]
        var result = ""
        result = "$result$can $chi"
        return result
    }

    /**
     * Lấy tên của tháng Âm Lịch ví dụ Giêng, Hai, Ba....Chạp.
     * Thông số nhập vào là tháng Âm Lịch 1..12
     */
    fun getLunarMonthNumberName(mm: Int): String {
        var result = ""
        if (mm >= 1 && mm <= 12) {
            result = THANG_AM[mm]
        }
        return result
    }

    fun getLunarDayName(
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): String {
        val solar = convertLunar2Solar(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]

        // Hiệu Can-Chi của ngày lặp lại theo chu kỳ 60 ngày, như thế nó cũng có
        // thể tính được một cách đơn giản. Cho N là số ngày Julius của ngày
        // dd/mm/yyyy. Ta chia N+9 cho 10. Số dư 0 là Giáp, 1 là Ất v.v. Để tìm
        // Chi, chia N+1 cho 12; số dư 0 là Tý, 1 là Sửu v.v.
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        val canNumber = INT((dayNumber + 9).toDouble()) % 10
        val chiNumber = INT((dayNumber + 1).toDouble()) % 12
        val can = CAN[canNumber]
        val chi = CHI[chiNumber]
        var result = ""
        result = "$result$can $chi"
        return result
    }

    /**
     * Lấy Can Ngày Index
     * Dữ liệu nhập vào là thông tin ngày âm lịch
     */
    fun getCanNgayIndex(
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): Int {
        val solar = convertLunar2Solar(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        return INT((dayNumber + 9).toDouble()) % 10
    }

    /**
     * Lấy Chi Ngày Index
     * Dữ liệu nhập vào là thông tin ngày âm lịch
     */
    fun getChiNgayIndex(
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): Int {
        val solar = convertLunar2Solar(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        return INT((dayNumber + 1).toDouble()) % 12
    }

    fun getLunarHourName(
        hh: Double,
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): String {
        val chiNumber = INT(hh + 1) % 24 / 2
        val solar = convertLunar2Solar(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        val canDayNumber = INT((dayNumber + 9).toDouble()) % 10
        val tyCan = canDayNumber % 5 * 2
        val canNumber = (tyCan + chiNumber) % 10
        val can = CAN[canNumber]
        val chi = CHI[chiNumber]
        var result = ""
        result = "$result$can $chi"
        return result
    }

    fun getNumberChiLunarHourName(hh: Double): Int {
        return INT(hh + 1) % 24 / 2
    }

    /**
     * Lấy mảng 6 giờ Hoàng Đạo theo cho 1 ngày
     * Dữ liệu trả ra Tý, Sửu, Dần, Mão...
     */
    fun getGioHoangDao(
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): Array<String?> {
        val solar = convertLunar2Solar(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        val chiNumber = INT((dayNumber + 1).toDouble()) % 12
        val firstNumber = GIO_HOANG_DAO[chiNumber]
        val index = IntArray(6)
        index[0] = firstNumber
        index[1] = (firstNumber + 1) % 12
        index[2] = (firstNumber + 4) % 12
        index[3] = (firstNumber + 5) % 12
        index[4] = (firstNumber + 7) % 12
        index[5] = (firstNumber + 10) % 12

        // Sắp xếp theo thứ tự Tí, Sửu, Dần .....
        for (i in 0..4) {
            for (j in i + 1..5) {
                if (index[i] > index[j]) {
                    val temp = index[i]
                    index[i] = index[j]
                    index[j] = temp
                }
            }
        }
        val gioHoangDao = arrayOfNulls<String>(6)
        gioHoangDao[0] = CHI[index[0]]
        gioHoangDao[1] = CHI[index[1]]
        gioHoangDao[2] = CHI[index[2]]
        gioHoangDao[3] = CHI[index[3]]
        gioHoangDao[4] = CHI[index[4]]
        gioHoangDao[5] = CHI[index[5]]
        return gioHoangDao
    }

    /**
     * Lấy mảng 6 giờ Hoàng Đạo theo cho 1 ngày
     * Dữ liệu trả ra 23h - 0:59, 1h - 2:59 ...
     */
    fun getGioHoangDaoSo(
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): Array<String?> {
        val solar = convertLunar2Solar(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        val chiNumber = INT((dayNumber + 1).toDouble()) % 12
        val firstNumber = GIO_HOANG_DAO[chiNumber]
        val index = IntArray(6)
        index[0] = firstNumber
        index[1] = (firstNumber + 1) % 12
        index[2] = (firstNumber + 4) % 12
        index[3] = (firstNumber + 5) % 12
        index[4] = (firstNumber + 7) % 12
        index[5] = (firstNumber + 10) % 12

        // Sắp xếp theo thứ tự Tí, Sửu, Dần .....
        for (i in 0..4) {
            for (j in i + 1..5) {
                if (index[i] > index[j]) {
                    val temp = index[i]
                    index[i] = index[j]
                    index[j] = temp
                }
            }
        }
        val gioHoangDao = arrayOfNulls<String>(6)
        gioHoangDao[0] = GIO_NGHIA[index[0]]
        gioHoangDao[1] = GIO_NGHIA[index[1]]
        gioHoangDao[2] = GIO_NGHIA[index[2]]
        gioHoangDao[3] = GIO_NGHIA[index[3]]
        gioHoangDao[4] = GIO_NGHIA[index[4]]
        gioHoangDao[5] = GIO_NGHIA[index[5]]
        return gioHoangDao
    }

    /**
     * Kiểm tra 1 hour có phải là giờ hoàng đạo không
     * Thông tin nhập vào là thông tin ngày âm lịch
     * Trả ra : 1: giờ hoàng đạo     0: Không phải giờ Hoàng Đạo
     */
    fun isGioHoangDao(
        hh: Int,
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): Int {
        val solar = convertLunar2Solar(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val hourNumber = INT((hh + 1).toDouble()) % 24 / 2
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        val chiNumber = INT((dayNumber + 1).toDouble()) % 12
        val firstNumber = GIO_HOANG_DAO[chiNumber]
        var result = 0
        if (hourNumber == firstNumber) {
            result = 1
        }
        if (hourNumber == (firstNumber + 1) % 12) {
            result = 1
        }
        if (hourNumber == (firstNumber + 4) % 12) {
            result = 1
        }
        if (hourNumber == (firstNumber + 5) % 12) {
            result = 1
        }
        if (hourNumber == (firstNumber + 7) % 12) {
            result = 1
        }
        if (hourNumber == (firstNumber + 10) % 12) {
            result = 1
        }
        return result
    }

    /**
     * Kiểm tra 1 ngày âm lịch có phải là ngày Hoàng Đạo hay không Thông số nhập
     * vào là ngày âm lịch Thông số trả ra : 1 là hoàng đạo, 0 là ngày bình
     * thường, -1 là hắc đạo
     */
    fun ngayHoangDao(
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): Int {
        val solar = convertLunar2Solar(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        val chiNumber = INT((dayNumber + 1).toDouble()) % 12
        return NGAY_HOANG_DAO[mm][chiNumber]
    }

    /**
     * Tính tiết khí cận dưới của một ngày Thông số nhập vào là ngày, tháng năm
     * Dương Lịch
     */
    fun getTietKhi(
        dd: Int,
        mm: Int,
        yy: Int,
        timeZone: Double
    ): Array<String?> {
        var sunLong = getSunLongitudeFromDate(
            dd,
            mm,
            yy,
            timeZone
        ) + chenhLechDo1Ngay
        var index = INT(sunLong / 15)
        if (index >= 24) {
            index = 0
            sunLong = 0.0
        }
        val tietKhi = TIET_KHI[index]
        val tietKhiNghia = TIET_KHI_NGHIA[index]
        val result: Array<String?>
        if (sunLong - index.toDouble() * 15 < 1.0) {
            // isDungTiet = 1;
            result = arrayOfNulls(2)
            result[0] = tietKhi
            result[1] = tietKhiNghia
        } else {
            result = arrayOfNulls(3)
            result[0] = tietKhi
            result[1] = tietKhiNghia
            val offset = sunLong - (index * 15).toDouble()
            result[2] = offset.toString()

            // isDungTiet = 0;
        }
        return result
    }

    /**
     * Tính tiết khí cận trên của 1 ngày Thông số nhập vào là ngày, tháng năm
     * Dương Lịch
     */
    fun getNextTietKhi(
        dd: Int,
        mm: Int,
        yy: Int,
        timeZone: Double
    ): Array<String?> {
        val sunLong = getSunLongitudeFromDate(
            dd,
            mm,
            yy,
            timeZone
        ) + chenhLechDo1Ngay
        var index = INT(sunLong / 15)
        index = index % 24
        index = index + 1
        if (index > 23) {
            index = 0
        }
        val tietKhi = TIET_KHI[index]
        val tietKhiNghia = TIET_KHI_NGHIA[index]
        val result: Array<String?>
        result = arrayOfNulls(2)
        result[0] = tietKhi
        result[1] = tietKhiNghia
        return result
    }

    /**
     * Lấy Hướng Hỷ Thần của ngày Âm Lịch ví dụ Nam, Bắc, Tây Bắc, Tây Nam ...
     * Thông số nhập vào là ngày, tháng năm âm lịch
     */
    fun getHuongHyThan(
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): String {
        val solar = convertLunar2Solar(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        val canNumber = INT((dayNumber + 9).toDouble()) % 10
        return HUONG_HY_THAN[canNumber]
    }

    /**
     * Lấy Hướng Hỷ Thần của ngày Âm Lịch ví dụ Nam, Bắc, Tây Bắc, Tây Nam ...
     * Thông số nhập vào là ngày, tháng năm âm lịch
     */
    fun getHuongTaiThan(
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): String {
        val solar = convertLunar2Solar(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        val canNumber = INT((dayNumber + 9).toDouble()) % 10
        return HUONG_TAI_THAN[canNumber]
    }

    /**
     * Lấy 4 tuổi khắc với ngày Thông số nhập vào là ngày âm
     */
    fun getTuoiKhac(
        lunarDay: Int,
        lunarMonth: Int,
        lunarYear: Int,
        lunarLeap: Int,
        timeZone: Double
    ): Array<String?> {
        val solar = convertLunar2Solar(
            lunarDay,
            lunarMonth,
            lunarYear,
            lunarLeap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        val canIndex = INT((dayNumber + 9).toDouble()) % 10
        val chiIndex = INT((dayNumber + 1).toDouble()) % 12
        val canKhac = (canIndex + 6) % 10
        val chiKhac = (chiIndex + 6) % 12
        val tuoiKhac = arrayOfNulls<String>(4)

        // Cung CAN cung CHI
        tuoiKhac[0] = CAN[canIndex] + " " + CHI[chiIndex]

        // Cung CAN khac CHI
        tuoiKhac[1] = CAN[canIndex] + " " + CHI[chiKhac]

        // khac CAN cung CHI
        tuoiKhac[2] = CAN[canKhac] + " " + CHI[chiIndex]

        // Khac CAN khac CHI
        tuoiKhac[3] = CAN[canKhac] + " " + CHI[chiKhac]
        return tuoiKhac
    }

    /**
     * Lấy 4 tuổi khắc với ngày
     */
    fun getTuoiKhacMoi(
        lunarDay: Int,
        lunarMonth: Int,
        lunarYear: Int,
        lunarLeap: Int,
        timeZone: Double
    ): String {
        val solar = convertLunar2Solar(
            lunarDay,
            lunarMonth,
            lunarYear,
            lunarLeap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        val canIndex = INT((dayNumber + 9).toDouble()) % 10
        val chiIndex = INT((dayNumber + 1).toDouble()) % 12
        var tuoiKhac = ""
        tuoiKhac = when (canIndex) {
            0 -> when (chiIndex) {
                0 -> "Mậu Ngọ, Nhâm Ngọ, Canh Dần, Canh Thân"
                10 -> "Nhâm Thìn, Canh Thìn, Canh Tuất"
                8 -> "Mậu Dần, Bính Dần, Canh Ngọ, Canh Tý"
                6 -> "Mậu Tý, Nhâm Tý, Canh Dần, Nhâm Dần"
                4 -> "Nhâm Tuất, Canh Tuất, Canh Thìn"
                2 -> "Mậu Thân, Bính Thân, Canh Ngọ, Canh Tý"
                else -> ""
            }

            1 -> when (chiIndex) {
                1 -> "Kỷ Mùi, Quý Mùi, Tân Mão, Tân Dậu"
                11 -> "Quý Tỵ, Tân Tỵ, Tân Hợi"
                9 -> "Kỷ Mão, Đinh Mão, Tân Mùi, Tân Sửu"
                7 -> "Kỷ Sửu, Quý Sửu, Tân Mão, Tân Dậu"
                5 -> "Quý Hợi, Tân Hợi, Tân Tỵ"
                3 -> "Kỷ Dậu, Đinh Dậu, Tân Mùi, Tân Sửu"
                else -> ""
            }

            2 -> when (chiIndex) {
                2 -> "Giáp Thân, Nhâm Thân, Nhâm Tuất, Nhâm Thìn"
                0 -> "Canh Ngọ, Mậu Ngọ"
                10 -> "Mậu Thìn, Nhâm Thìn, Nhâm Ngọ, Nhâm Tý"
                8 -> "Giáp Dần, Nhâm Thân, Nhâm Tuất, Nhâm Thìn"
                6 -> "Mậu Tý, Canh Tý"
                4 -> "Mậu Tuất, Nhâm Tuất, Nhâm Ngọ, Nhâm Tý"
                else -> ""
            }

            3 -> when (chiIndex) {
                3 -> "Ất Dậu, Quý Dậu, Quý Tỵ, Quý Hợi"
                1 -> "Tân Mùi, Kỷ Mùi"
                11 -> "Kỷ Tỵ, Quý Tỵ, Quý Mùi, Quý Sửu"
                9 -> "Ất Mão, Quý Mão, Quý Tỵ, Quý Hợi"
                7 -> "Kỷ Sửu, Tân Sửu"
                5 -> "Kỷ Hợi, Quý Hợi, Quý Sửu, Quý Mùi"
                else -> ""
            }

            4 -> when (chiIndex) {
                4 -> "Canh Tuất, Bính Tuất"
                2 -> "Canh Thân, Giáp Thân"
                0 -> "Bính Ngọ, Giáp Ngọ"
                10 -> "Canh Thìn, Bính Thìn"
                8 -> "Canh Dần, Giáp Dần"
                6 -> "Bính Tý, Giáp Tý"
                else -> ""
            }

            5 -> when (chiIndex) {
                5 -> "Tân Hợi, Đinh Hợi"
                3 -> "Tân Dậu, Ất Dậu"
                1 -> "Đinh Mùi, Ất Mùi"
                11 -> "Tân Tỵ, Đinh Tỵ"
                9 -> "Tân Mão, Ất Mão"
                7 -> "Đinh Sửu, Ất Sửu"
                else -> ""
            }

            6 -> when (chiIndex) {
                6 -> "Nhâm Tý, Bính Tý, Giáp Thân, Giáp Dần"
                4 -> "Giáp Tuất, Mậu Tuất, Giáp Thìn"
                2 -> "Nhâm Thân, Mậu Thân, Giáp Tý, Giáp Ngọ"
                0 -> "Nhâm Ngọ, Bính Ngọ, Giáp Thân, Giáp Dần"
                10 -> "Giáp Thìn, Mậu Thìn, Giáp Tuất"
                8 -> "Nhâm Dần, Mậu Dần, Giáp Tý, Giáp Ngọ"
                else -> ""
            }

            7 -> when (chiIndex) {
                7 -> "Quý Sửu, Đinh Sửu, Ất Dậu, Ất Mão"
                5 -> "Ất Hợi, Kỷ Hợi, Ất Tỵ"
                3 -> "Quý Dậu, Kỷ Dậu, Ất Sửu, Ất Mùi"
                1 -> "Quý Mùi, Đinh Mùi, Ất Dậu, Ất Mão"
                11 -> "Ất Tỵ, Kỷ Tỵ, Ất Hợi"
                9 -> "Quý Mão, Kỷ Mão, Ất Sửu, Ất Mùi"
                else -> ""
            }

            8 -> when (chiIndex) {
                8 -> "Bính Dần, Canh Dần, Bính Thân"
                6 -> "Giáp Tý, Canh Tý, Bính Tuất, Bính Thìn"
                4 -> "Bính Tuất, Giáp Tuất, Bính Dần"
                2 -> "Canh Thân, Bính Thân, Bính Dần"
                0 -> "Giáp Ngọ, Canh Ngọ, Bính Tuất, Bính Thìn"
                10 -> "Bính Thìn, Giáp Thìn, Bính Thân, Bính Dần"
                else -> ""
            }

            9 -> when (chiIndex) {
                9 -> "Đinh Mão, Tân Mão, Đinh Dậu"
                7 -> "Ất Sửu, Tân Sửu, Đinh Hợi, Đinh Tỵ"
                5 -> "Đinh Hợi, Ất Hợi, Đinh Mão"
                3 -> "Tân Dậu, Đinh Dậu, Đinh Mão"
                1 -> "Ất Mùi, Tân Mùi, Đinh Hợi, Đinh Tỵ"
                11 -> "Đinh Tỵ, Ất Tỵ, Đinh Mão, Đinh Dậu"
                else -> ""
            }

            else -> ""
        }
        return tuoiKhac
    }

    /**
     * Lấy Ngũ Hành index của ngày Thông số nhập vào là ngày, tháng năm âm lịch
     */
    fun getHanhNgayIndex(
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): Int {
        val solar = convertLunar2Solar(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        val canIndex = INT((dayNumber + 9).toDouble()) % 10
        val chiIndex = INT((dayNumber + 1).toDouble()) % 12
        val canSoIndex = CAN_SO[canIndex]
        val chiSoIndex = CHI_SO[chiIndex]
        var plus = canSoIndex + chiSoIndex
        if (plus > 5) {
            plus -= 5
        }
        return NGU_HANH_INDEX[plus]
    }

    /**
     * Lấy Ngũ Hành của ngày Thông số nhập vào là ngày, tháng năm âm lịch
     */
    fun getHanhNgay(
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): String {
        val hanhIndex = getHanhNgayIndex(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        return NGU_HANH[hanhIndex]
    }

    /**
     * Lấy Ngũ Hành của người khắc hành
     */
    fun getHanhNgayKhac(
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): String {
        val hanhIndex = getHanhNgayIndex(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        val khac = (hanhIndex + 2) % 5
        return NGU_HANH[khac]
    }

    /**
     * Lấy Ngũ Hành của người khắc hành
     */
    fun getHanhNgaySinh(
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): String {
        val hanhIndex = getHanhNgayIndex(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        val sinh = (hanhIndex + 1) % 5
        return NGU_HANH[sinh]
    }

    /**
     * Lấy tháng tiết khí của 1 ngày dương lịch VD : Sau Lâp Xuân: tháng 0, sau
     * Kinh Trập :1
     */
    fun getThangTietKhi(
        dd: Int,
        mm: Int,
        yy: Int,
        timeZone: Double
    ): Int {
        val sunLong = getSunLongitudeFromDate(
            dd,
            mm,
            yy,
            timeZone
        ) + chenhLechDo1Ngay
        var index = INT(sunLong / 15)
        index = index % 24
        index = (index + 3) % 24
        return index / 2
    }

    /**
     * Lấy Trực của ngày Thông số nhập vào là ngày, tháng năm âm lịch
     */
    fun getTrucIndex(
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): Int {
        val solar = convertLunar2Solar(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        val chiNumber = INT((dayNumber + 1).toDouble()) % 12
        val thangTietKhi = getThangTietKhi(
            day,
            month,
            year,
            timeZone
        )
        val ngayKien = (thangTietKhi + 2) % 12
        var chenhlech = 0
        chenhlech = if (ngayKien <= chiNumber) {
            chiNumber - ngayKien
        } else {
            12 - (ngayKien - chiNumber)
        }
        return chenhlech
    }

    /**
     * Lấy tên trực của 1 ngày âm lịch
     */
    fun getTruc(
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): String {
        val index = getTrucIndex(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        return TRUC[index]
    }

    /**
     * Lấy ý nghĩa của trực của 1 ngày âm lịch
     */
    fun getTrucNghia(
        dd: Int,
        mm: Int,
        yy: Int,
        leap: Int,
        timeZone: Double
    ): String {
        val index = getTrucIndex(
            dd,
            mm,
            yy,
            leap,
            timeZone
        )
        return TRUC_NGHIA[index]
    }

    /**
     * Lấy index của sao theo Nhị thập bát tú soNgay : tổng số ngày từ ngày
     * 1/1/1995 đến ngày cần tính
     */
    fun getSaoIndex(soNgay: Long): Int {
        var index: Long = -1
        if (soNgay >= 0) {
            index = soNgay % 28
        } else {
            index = soNgay % 28
            index = (28 + index) % 28
        }
        return index.toInt()
    }

    /**
     * Lấy Tên Sao theo Nhị thập bát tú
     *
     * @param soNgay
     * tổng số ngày từ ngày 1/1/1995 đến ngày cần tính
     * @return
     */
    fun getSao(soNgay: Long): String {
        val index = getSaoIndex(soNgay)
        return NHI_THAP_BAT_TU[index]
    }

    /**
     * Lấy Ý Nghĩa của Sao theo Nhị thập bát tú
     *
     * @param soNgay
     * : tổng số ngày từ ngày 1/1/1995 đến ngày cần tính
     * @return Text nói về ý nghĩa và tính chẩ của Sao
     */
    fun getSaoNghia(soNgay: Long): String {
        val index = getSaoIndex(soNgay)
        return NHI_THAP_BAT_TU_NGHIA[index]
    }

    /**
     * Kiểm tra 1 ngày phải là ngày Tam Nương hay không
     * Mọi việc đều kỵ, chánh kỵ xuất hành
     */
    fun isTamNuong(
        lunarDay: Int,
        lunarMonth: Int,
        lunarYear: Int,
        lunarLeap: Int,
        timeZone: Double
    ): Int {
        return if (lunarDay == 3 || lunarDay == 7 || lunarDay == 13 || lunarDay == 18 || lunarDay == 22 || lunarDay == 27) {
            1
        } else 0
    }

    /**
     * Kiểm tra 1 ngày phải là ngày Nguyệt Kỵ hay không
     * Không nên khởi tạo việc gì cả
     */
    fun isNguyetKy(
        lunarDay: Int,
        lunarMonth: Int,
        lunarYear: Int,
        lunarLeap: Int,
        timeZone: Double
    ): Int {
        return if (lunarDay == 5 || lunarDay == 14 || lunarDay == 23) {
            1
        } else 0
    }

    /**
     * Kiểm tra 1 ngày phải là ngày Dương Công Kỵ không
     * Kết quả 1 là ngày Dương Công Kỵ
     * Ngày xấu nhất trong năm, tránh tất cả các việc trọng đại.
     */
    fun isDuongCongKy(
        lunarDay: Int,
        lunarMonth: Int,
        lunarYear: Int,
        lunarLeap: Int,
        timeZone: Double
    ): Int {
        var result = 0
        when (lunarMonth) {
            1 -> if (lunarDay == 13) {
                result = 1
            }

            2 -> if (lunarDay == 11) {
                result = 1
            }

            3 -> if (lunarDay == 9) {
                result = 1
            }

            4 -> if (lunarDay == 7) {
                result = 1
            }

            5 -> if (lunarDay == 5) {
                result = 1
            }

            6 -> if (lunarDay == 3) {
                result = 1
            }

            7 -> if (lunarDay == 1 || lunarDay == 29) {
                result = 1
            }

            8 -> if (lunarDay == 27) {
                result = 1
            }

            9 -> if (lunarDay == 25) {
                result = 1
            }

            10 -> if (lunarDay == 23) {
                result = 1
            }

            11 -> if (lunarDay == 21) {
                result = 1
            }

            12 -> if (lunarDay == 19) {
                result = 1
            }

            else -> {}
        }
        return result
    }

    /**
     * Kiểm tra 1 ngày phải là ngày Sát Chủ hay không
     * Kết quả 1 là ngày Sát Chủ
     * Ngày sát chủ kỵ làm nhà cưới gả
     */
    fun isNgaySatChu(
        lunarDay: Int,
        lunarMonth: Int,
        lunarYear: Int,
        lunarLeap: Int,
        timeZone: Double
    ): Int {
        val solar = convertLunar2Solar(
            lunarDay,
            lunarMonth,
            lunarYear,
            lunarLeap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        val chiIndex = INT((dayNumber + 1).toDouble()) % 12
        var result = 0
        when (lunarMonth) {
            1 -> if (chiIndex == 5) {
                result = 1
            }

            2 -> if (chiIndex == 0) {
                result = 1
            }

            3 -> if (chiIndex == 7) {
                result = 1
            }

            4 -> if (chiIndex == 3) {
                result = 1
            }

            5 -> if (chiIndex == 8) {
                result = 1
            }

            6 -> if (chiIndex == 10) {
                result = 1
            }

            7 -> if (chiIndex == 11) {
                result = 1
            }

            8 -> if (chiIndex == 1) {
                result = 1
            }

            9 -> if (chiIndex == 6) {
                result = 1
            }

            10 -> if (chiIndex == 9) {
                result = 1
            }

            11 -> if (chiIndex == 2) {
                result = 1
            }

            12 -> if (chiIndex == 4) {
                result = 1
            }

            else -> {}
        }
        return result
    }

    /**
     * Kiểm tra 1 ngày phải là ngày Thọ Tử hay không
     * Kết quả 1 là ngày Thọ Tử
     * Ngày thọ tử kỵ làm nhà cưới gả
     */
    fun isNgayThoTu(
        lunarDay: Int,
        lunarMonth: Int,
        lunarYear: Int,
        lunarLeap: Int,
        timeZone: Double
    ): Int {
        val solar = convertLunar2Solar(
            lunarDay,
            lunarMonth,
            lunarYear,
            lunarLeap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        val canIndex = INT((dayNumber + 9).toDouble()) % 10
        val chiIndex = INT((dayNumber + 1).toDouble()) % 12
        var result = 0
        when (lunarMonth) {
            1 -> if (canIndex == 2 && chiIndex == 10) {
                result = 1
            }

            2 -> if (canIndex == 8 && chiIndex == 4) {
                result = 1
            }

            3 -> if (canIndex == 7 && chiIndex == 11) {
                result = 1
            }

            4 -> if (canIndex == 3 && chiIndex == 5) {
                result = 1
            }

            5 -> if (canIndex == 4 && chiIndex == 0) {
                result = 1
            }

            6 -> if (canIndex == 2 && chiIndex == 6) {
                result = 1
            }

            7 -> if (canIndex == 1 && chiIndex == 1) {
                result = 1
            }

            8 -> if (canIndex == 9 && chiIndex == 7) {
                result = 1
            }

            9 -> if (canIndex == 0 && chiIndex == 2) {
                result = 1
            }

            10 -> if (canIndex == 4 && chiIndex == 8) {
                result = 1
            }

            11 -> if (canIndex == 7 && chiIndex == 3) {
                result = 1
            }

            12 -> if (canIndex == 7 && chiIndex == 9) {
                result = 1
            }

            else -> {}
        }
        return result
    }

    /**
     * Kiểm tra 1 ngày phải là ngày Vãng Vong hay không
     * Kết quả 1 là ngày Vãng Vong
     * Ngày vãng vong trăm sự đều kỵ, tránh kỵ xuất hành
     */
    fun isNgayVangVong(
        lunarDay: Int,
        lunarMonth: Int,
        lunarYear: Int,
        lunarLeap: Int,
        timeZone: Double
    ): Int {
        val solar = convertLunar2Solar(
            lunarDay,
            lunarMonth,
            lunarYear,
            lunarLeap,
            timeZone
        )
        val day = solar[0]
        val month = solar[1]
        val year = solar[2]
        val dayNumber = jdFromDate(
            day,
            month,
            year
        )
        val chiIndex = INT((dayNumber + 1).toDouble()) % 12
        var result = 0
        when (lunarMonth) {
            1 -> if (chiIndex == 2) {
                result = 1
            }

            2 -> if (chiIndex == 5) {
                result = 1
            }

            3 -> if (chiIndex == 8) {
                result = 1
            }

            4 -> if (chiIndex == 11) {
                result = 1
            }

            5 -> if (chiIndex == 3) {
                result = 1
            }

            6 -> if (chiIndex == 6) {
                result = 1
            }

            7 -> if (chiIndex == 9) {
                result = 1
            }

            8 -> if (chiIndex == 0) {
                result = 1
            }

            9 -> if (chiIndex == 4) {
                result = 1
            }

            10 -> if (chiIndex == 7) {
                result = 1
            }

            11 -> if (chiIndex == 10) {
                result = 1
            }

            12 -> if (chiIndex == 1) {
                result = 1
            }

            else -> {}
        }
        return result
    }

    /**
     * Kiểm tra 1 ngày phải là ngày Con Nước hay không
     * Kết quả 1 là ngày Ngày Con Nước
     * - gioNuocLen (0: Tý, 1: Sửu...11:Hợi) Giờ nước lên trong ngày con nước
     * - gioNuocLen + 1 : Giờ nước xuống
     */
    fun isNgayConNuoc(
        lunarDay: Int,
        lunarMonth: Int,
        lunarYear: Int,
        lunarLeap: Int,
        timeZone: Double
    ): IntArray {
        val result = IntArray(2)
        when (lunarMonth) {
            1 -> {
                if (lunarDay == 5 || lunarDay == 19) {
                    result[0] = 1
                }
                result[1] = 5
            }

            2 -> {
                if (lunarDay == 3 || lunarDay == 17 || lunarDay == 29) {
                    result[0] = 1
                }
                result[1] = 6
            }

            3 -> {
                if (lunarDay == 13 || lunarDay == 27) {
                    result[0] = 1
                }
                result[1] = 11
            }

            4 -> {
                if (lunarDay == 11 || lunarDay == 25) {
                    result[0] = 1
                }
                result[1] = 7
            }

            5 -> {
                if (lunarDay == 9 || lunarDay == 23) {
                    result[0] = 1
                }
                result[1] = 4
            }

            6 -> {
                if (lunarDay == 7 || lunarDay == 21) {
                    result[0] = 1
                }
                result[1] = 1
            }

            7 -> {
                if (lunarDay == 5 || lunarDay == 19) {
                    result[0] = 1
                }
                result[1] = 5
            }

            8 -> {
                if (lunarDay == 3 || lunarDay == 17 || lunarDay == 29) {
                    result[0] = 1
                }
                result[1] = 6
            }

            9 -> {
                if (lunarDay == 13 || lunarDay == 27) {
                    result[0] = 1
                }
                result[1] = 11
            }

            10 -> {
                if (lunarDay == 11 || lunarDay == 25) {
                    result[0] = 1
                }
                result[1] = 7
            }

            11 -> {
                if (lunarDay == 9 || lunarDay == 23) {
                    result[0] = 1
                }
                result[1] = 4
            }

            12 -> {
                if (lunarDay == 7 || lunarDay == 21) {
                    result[0] = 1
                }
                result[1] = 1
            }

            else -> {}
        }
        return result
    }

    /**
     * Kiểm tra 1 ngày phải là ngày Vạn Sự Không Lành hay không
     * Kết quả 1 là ngày Vạn Sự Không Lành
     * Tránh những việc quan trọng, nếu không tránh được thì phải hết sức thận trọng
     */
    fun isNgayVanSuKhongLanh(
        lunarDay: Int,
        lunarMonth: Int,
        lunarYear: Int,
        lunarLeap: Int,
        timeZone: Double
    ): Int {
        var result = 0
        when (lunarMonth) {
            1 -> if (lunarDay == 3 || lunarDay == 11 || lunarDay == 19 || lunarDay == 27) {
                result = 1
            }

            2 -> if (lunarDay == 2 || lunarDay == 10 || lunarDay == 18 || lunarDay == 26) {
                result = 1
            }

            3 -> if (lunarDay == 1 || lunarDay == 9 || lunarDay == 17 || lunarDay == 25) {
                result = 1
            }

            4 -> if (lunarDay == 4 || lunarDay == 12 || lunarDay == 20 || lunarDay == 28) {
                result = 1
            }

            5 -> if (lunarDay == 5 || lunarDay == 13 || lunarDay == 21 || lunarDay == 29) {
                result = 1
            }

            6 -> if (lunarDay == 6 || lunarDay == 14 || lunarDay == 22 || lunarDay == 30) {
                result = 1
            }

            7 -> if (lunarDay == 3 || lunarDay == 11 || lunarDay == 19 || lunarDay == 27) {
                result = 1
            }

            8 -> if (lunarDay == 2 || lunarDay == 10 || lunarDay == 18 || lunarDay == 26) {
                result = 1
            }

            9 -> if (lunarDay == 1 || lunarDay == 9 || lunarDay == 17 || lunarDay == 25) {
                result = 1
            }

            10 -> if (lunarDay == 4 || lunarDay == 12 || lunarDay == 20 || lunarDay == 28) {
                result = 1
            }

            11 -> if (lunarDay == 5 || lunarDay == 13 || lunarDay == 21 || lunarDay == 29) {
                result = 1
            }

            12 -> if (lunarDay == 6 || lunarDay == 14 || lunarDay == 22 || lunarDay == 30) {
                result = 1
            }

            else -> {}
        }
        return result
    }
    /** Kiểm tra 1 ngày là ngày thứ mấy trong tuần
     * Dữ liệu nhập vào là thông tin ngày âm lịch
     * Dữ liệu trả ra  0: Chủ Nhật, 1 : Thứ Hai...6:Thứ 7
     */
    /*
     public static   int ngayThuIndex(int dd, int mm, int yy, int leap,double timeZone)
     {
     int[] solar = convertLunar2Solar(dd, mm, yy, leap, timeZone);
     int day = solar[0];
     int month = solar[1];
     int year = solar[2];
     
     if (month <3) {
     month= month + 12;
     year = year - 1;
     }
     
     int n = (day+2*month+(3*(month+1))/5 + year + (year/ 4)) % 7;
     
     return n;
     }
     */
    /**
     * Kiểm tra 1 ngày là ngày thứ mấy trong tuần
     * Dữ liệu nhập vào là thông tin ngày dương lịch
     * Dữ liệu trả ra  0: Chủ Nhật, 1 : Thứ Hai...6:Thứ 7
     */
    fun ngayThuIndex(
        day: Int,
        month: Int,
        year: Int
    ): Int {
        val a = (14 - month) / 12
        val y = year - a
        val m = month + 12 * a - 2
        return (day + y + y / 4 - y / 100 + y / 400 + 31 * m / 12) % 7
    }

    /**
     * Kiểm tra 1 ngày là ngày thứ mấy trong tuần
     * Dữ liệu nhập vào là thông tin ngày dương lịch
     * Dữ liệu trả ra   Chủ Nhật,Thứ Hai...Thứ 7
     */
    fun ngayThuTen(
        day: Int,
        month: Int,
        year: Int
    ): String {
        val thu = ngayThuIndex(
            day,
            month,
            year
        )
        return THU[thu]
    }

    /**
     * Lấy số ngày trong tháng dương lịch
     */
    fun getTotalDayOfMonthSolar(
        monthSolar: Int,
        yearSolar: Int
    ): Int {
        val calendar: Calendar = GregorianCalendar(
            yearSolar,
            monthSolar - 1,
            10
        )
        // Get the number of days in that month
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val timeZone = 7.0
        val calendar = Calendar.getInstance()
        // int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);// ex: thu 2
        val day = 12 //calendar.get(Calendar.DAY_OF_MONTH);
        val year = calendar[Calendar.YEAR]
        val month = 9 // calendar.get(Calendar.MONTH) + 1;
        val hour = 14 //calendar.get(Calendar.HOUR);
        println(
            "\n Days:" + getTotalDayOfMonthSolar(
                month,
                year
            )
        )


        /*
         int day = 8;
         int month = 1;
         int year = 2018;
         int hour = 14;
         */
        val lunar = convertSolar2Lunar(
            day,
            month,
            year,
            timeZone
        )
        val lunarDay = lunar[0]
        val lunarMonth = lunar[1]
        val lunarYear = lunar[2]
        val isLeap = lunar[3]
        println("\n*******************************************************")

        // Thông tin ngày giờ AL và DL
        println("- Dương lịch: $day/$month/$year")
        println("- Âm lịch: $lunarDay/$lunarMonth/$lunarYear")
        val yearName = getLunarYearName(lunarYear)
        val monthName = getLunarMonthName(
            lunarMonth,
            lunarYear,
            isLeap
        )
        val monthNumberName = getLunarMonthNumberName(lunarMonth)
        val dayName = getLunarDayName(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        val hourName = getLunarHourName(
            hour.toDouble(),
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        val ngayThu = ngayThuTen(
            day,
            month,
            year
        )

        // Thông tin tên ngày, giờ, tháng, năm AL
        println("- Giờ: $hourName,$ngayThu, Ngày $dayName, Tháng $monthName ($monthNumberName) , Năm $yearName")


        //Can Chi Index
        val canIndex = getCanNgayIndex(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        val chiIndex = getChiNgayIndex(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        println("- Can index: $canIndex   Chi index:$chiIndex")


        // Kiểm tra ngày Hoàng Đạo
        val isHoangDao = ngayHoangDao(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        if (isHoangDao == 1) {
            println("- NGÀY HOÀNG ĐẠO")
        } else if (isHoangDao == -1) {
            println("- NGÀY HẮC ĐẠO")
        } else {
            println("- NGÀY KHÔNG HOÀNG ĐẠO VÀ HẮC ĐẠO")
        }

        // Lấy tiết khí
        val tietKhi = getTietKhi(
            day,
            month,
            year,
            timeZone
        )
        val nextTietkhi = getNextTietKhi(
            day,
            month,
            year,
            timeZone
        )
        if (tietKhi.size <= 2) {
            println("- Tiết khí: " + tietKhi[0] + "(" + tietKhi[1] + ")")
        } else {
            val offset = tietKhi[2]!!.toDouble()
            println("- Tiết khí:  Giữa " + tietKhi[0] + "(" + tietKhi[1] + ") và " + nextTietkhi[0] + "(" + nextTietkhi[1] + ")  Offset: " + offset / 15)
        }

        // Hướng Hỷ Thần và Tài Thần
        val huongHyThan = getHuongHyThan(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        val huongTaiThan = getHuongTaiThan(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        println("- Hướng Xuất Hành:     Hỷ Thấn:$huongHyThan   Tài Thấn:$huongTaiThan")

        // Giờ Hoàng Đạo
        val arrGioHoangDao = getGioHoangDao(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        val arrGioHoangDaoSo = getGioHoangDaoSo(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        println(
            "- Giờ Hoàng Đạo:  " + arrGioHoangDao[0] + "  " + arrGioHoangDao[1] + "  "
                    + arrGioHoangDao[2] + "  " + arrGioHoangDao[3] + "  " + arrGioHoangDao[4] + "  " + arrGioHoangDao[5]
        )
        println(
            "- Tương ứng:  " + arrGioHoangDaoSo[0] + "  " + arrGioHoangDaoSo[1] + "  "
                    + arrGioHoangDaoSo[2] + "  " + arrGioHoangDaoSo[3] + "  " + arrGioHoangDaoSo[4] + "  " + arrGioHoangDaoSo[5]
        )
        val isGioHoangDao = isGioHoangDao(
            hour,
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        if (isGioHoangDao == 1) {
            println(" $hour là giờ Hoàng Đạo")
        } else {
            println(" $hour không là giờ Hoàng Đạo")
        }

        // Tuổi Xung
        /*
         String[] tuoiKhac = getTuoiKhac(lunarDay, lunarMonth, lunarYear, isLeap, timeZone);
         
         System.out
         .println("- Tuổi Khắc: " + tuoiKhac[0] + ", " + tuoiKhac[1] + ", " + tuoiKhac[2] + ", " + tuoiKhac[3]);
         */
        val tuoiKhac = getTuoiKhacMoi(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        println("- Tuổi Khắc: $tuoiKhac")

        // Ngày Tốt, Ngày Xấu, Sao tốt sao xấu
        println("- NGÀY TỐT, NGÀY XẤU")
        // Hành Ngày
        val hanhNgay = getHanhNgay(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        val hanhSinh = getHanhNgaySinh(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        val hanhKhac = getHanhNgayKhac(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        println(
            "  - Hành : " + hanhNgay.uppercase(Locale.getDefault()) + " - Hợp với người mệnh " + hanhSinh.uppercase(
                Locale.getDefault()
            ) + ", Khắc với người mệnh " + hanhKhac.uppercase(Locale.getDefault())
        )

        // Lấy sao theo nhị thấp bát tú
        // daysBetween2Dates là số ngày từ 1/1/1995 đến ngày cần tính, khi code
        // thiệt phải tính giá trị này
        val daysBetween2Dates: Long = 5 // for testing only
        val saoIndex = getSaoIndex(daysBetween2Dates)
        val sao = getSao(daysBetween2Dates)
        val saoNghia = getSaoNghia(daysBetween2Dates)
        println("  - Sao : $sao - $saoNghia")

        // Trực Ngày
        val truc = getTruc(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        val trucNghia = getTrucNghia(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        println("  - Trực : $truc - $trucNghia")


        //Thong tin các ngày đặc biêt

        //Kiểm tra ngày Tam Nương
        val ngayTamnuong = isTamNuong(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        if (ngayTamnuong == 1) {
            println("- Ngày Tam Nương - Mọi việc đều kỵ, chánh kỵ xuất hành")
        }


        //Kiểm tra ngày Nguyệt Kỵ
        val ngayNguyetky = isNguyetKy(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        if (ngayNguyetky == 1) {
            println("- Ngày Nguyệt Kỵ - Không nên khởi tạo việc gì cả")
        }


        //Kiểm tra ngày Sát Chủ
        val ngaySatChu = isNgaySatChu(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        if (ngaySatChu == 1) {
            println("- Ngày Sát Chủ - Kỵ làm nhà cưới gả.")
        }

        //Kiểm tra ngày Thọ Tử
        val ngayThoTu = isNgayThoTu(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        if (ngayThoTu == 1) {
            println("- Ngày Thọ Tử - Kỵ làm nhà cưới gả.")
        }
        //Kiểm tra ngày Vãng Vong
        val ngayVangVong = isNgayVangVong(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        if (ngayVangVong == 1) {
            println("- Ngày Vãng Vong - Mọi việc đều kỵ, chánh kỵ xuất hành.")
        }
        val ngayConNuoc = isNgayConNuoc(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        if (ngayConNuoc[0] == 1) {
            println("-  - Ngày Con Nước: Ngày xấu, kỵ tất cả các việc. Kỵ nhất vào giờ..." + CHI[ngayConNuoc[1]] + "(" + GIO_NGHIA[ngayConNuoc[1]] + ")")
        }


        //Kiểm tra ngày Vạn Sự Không Lành
        val ngayVanSuKhongLanh = isNgayVanSuKhongLanh(
            lunarDay,
            lunarMonth,
            lunarYear,
            isLeap,
            timeZone
        )
        if (ngayVanSuKhongLanh == 1) {
            println("- Ngày Vạn Sự Không Lành: Tránh những việc quan trọng, nếu không tránh được thì phải hết sức thận trọng")
        }


        // Ngày Tốt, Ngày Xấu, Sao tốt sao xấu
        println("\n\n- THEO NHỊ THẬP BÁT TÚ: ")
        //Read file
        val fileName = "sao$saoIndex.txt"
        println("\n Read file:[$fileName] here!!!")


        /*
         
         //Begin doc file
         String line = null;
         File file = new File( "/Volumes/HD/MySpace/Java/SolarLunarSample/src/net/tuviphongthuy/lichvannien/src/sao"+saoIndex+".txt" );
         
         FileReader fr = null;
         try
         {
         fr = new FileReader( file );
         
         BufferedReader br = new BufferedReader( fr );
         try
         {
         while( (line = br.readLine()) != null )
         {
         System.out.println(line );
         }
         }catch (Exception e) {
         // TODO: handle exception
			    	 System.out.println( e.toString() );
         e.printStackTrace();
         }
         }
         catch (FileNotFoundException e)
         {
         System.out.println( "File doesn't exist" );
         e.printStackTrace();
         }
         
         //End doc file
         */println("\n*******************************************************")
    }
}