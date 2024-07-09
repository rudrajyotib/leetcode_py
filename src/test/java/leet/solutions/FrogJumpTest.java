package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrogJumpTest {

    @Test
    public void testCase1() {
        assertTrue(new FrogJump().solve(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        assertFalse(new FrogJump().solve(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }

    @Test
    public void testCase2() {
        assertTrue(new FrogJump().solve(new int[]{0, 1, 2, 4, 7, 9, 10, 12, 13, 14, 16, 17, 19, 22, 24, 27, 29, 31, 32, 33, 34, 36, 39, 42, 44, 47,
                51, 55, 59, 63, 66, 68, 70, 72, 73, 74, 75, 76, 77, 79, 82, 84, 86, 89, 92, 96, 99, 102, 104, 107, 110, 114, 118, 121, 124, 126, 129,
                133, 137, 141, 146, 151, 156, 161, 165, 169, 174, 179, 184, 188, 192, 197, 203, 209, 214, 218, 223, 229, 234, 240, 246, 252, 259, 266,
                272, 277, 283, 288, 292, 296, 301, 305, 308, 310, 312, 314, 317, 321, 325, 329, 332, 335, 339, 343, 348, 354, 359, 364, 368, 373, 378,
                383, 389, 395, 400, 404, 408, 413, 418, 422, 426, 430, 433, 435, 436, 438, 439, 440, 442, 445, 448, 452, 457, 462, 466, 471, 475, 480,
                486, 491, 497, 503, 508, 512, 516, 519, 521, 522, 524, 527, 530, 532, 535, 537, 538, 540, 542, 545, 547, 548, 549, 550, 551, 552, 553,
                555, 558, 561, 564, 566, 567, 569, 572, 575, 577, 580, 582, 584, 585, 587, 589, 591, 593, 594, 596, 599, 603, 608, 612, 617, 622, 626, 630,
                635, 639, 644, 648, 651, 655, 659, 663, 666, 670, 675, 681, 688, 695, 701, 707, 712, 716, 719, 723, 728, 734, 741, 747, 754, 762, 771, 781,
                792, 804, 815, 825, 836, 847, 858, 868, 878, 888, 897, 905, 912, 920, 927, 933, 938, 944, 950, 957, 964, 970, 977, 983, 988, 993, 998, 1004,
                1010, 1015, 1019, 1022, 1025, 1029, 1033, 1036, 1038, 1039, 1041, 1043, 1046, 1049, 1051, 1053, 1056, 1058, 1060, 1063, 1067, 1072, 1076, 1081,
                1087, 1093, 1098, 1103, 1108, 1112, 1116, 1121, 1125, 1128, 1131, 1133, 1134, 1136, 1138, 1139, 1140, 1142, 1143, 1144, 1145, 1146, 1148, 1150,
                1153, 1157, 1162, 1166, 1169, 1172, 1175, 1179, 1182, 1184, 1186, 1188, 1190, 1193, 1197, 1200, 1204, 1209, 1214, 1220, 1225, 1231, 1238, 1246,
                1255, 1263, 1272, 1280, 1288, 1296, 1303, 1310, 1317, 1325, 1334, 1342, 1351, 1361, 1370, 1380, 1391, 1403, 1414, 1426, 1439, 1451, 1463, 1476, 1490,
                1503, 1515, 1527, 1540, 1553, 1566, 1579, 1592, 1605, 1617, 1628, 1640, 1652, 1663, 1675, 1686, 1698, 1711, 1724, 1737, 1751, 1765, 1780, 1796, 1813,
                1830, 1847, 1864, 1881, 1898, 1915, 1933, 1951, 1969, 1986, 2003, 2020, 2037, 2053, 2068, 2083, 2098, 2113, 2128, 2142, 2155, 2169, 2183, 2198, 2212,
                2225, 2238, 2250, 2263, 2276, 2290, 2303, 2316, 2329, 2341, 2352, 2363, 2375, 2388, 2400, 2413, 2426, 2438, 2449, 2460, 2470, 2479, 2487, 2495, 2503,
                2510, 2516, 2521, 2527, 2532, 2536, 2540, 2543, 2547, 2552, 2557, 2561, 2566, 2570, 2573, 2576, 2579, 2583, 2588, 2593, 2598, 2602, 2607, 2611, 2616, 2622,
                2628, 2634, 2639, 2645, 2652, 2659, 2666, 2673, 2680, 2686, 2693, 2701, 2710, 2719, 2727, 2735, 2742, 2748, 2754, 2761, 2767, 2772, 2777, 2783, 2790, 2797,
                2803, 2808, 2814, 2820, 2825, 2830, 2836, 2842, 2848, 2853, 2858, 2863, 2867, 2871, 2875, 2878, 2881, 2883, 2886, 2889, 2893, 2898, 2903, 2907,
                2910, 2914, 2918, 2922, 2925, 2928, 2932, 2936, 2939, 2941, 2943, 2946, 2950, 2954, 2959, 2963, 2968, 2973, 2979, 2985, 2991, 2998, 3005, 3011,
                3016, 3021, 3026, 3032, 3037, 3042, 3046, 3050, 3053, 3057, 3062, 3067, 3072, 3076, 3080, 3084, 3089, 3095, 3102, 3109, 3116, 3122, 3128, 3135,
                3141, 3148, 3155, 3162, 3170, 3177, 3185, 3194, 3203, 3212, 3220, 3229, 3239, 3249, 3259, 3270, 3281, 3293, 3304, 3316, 3328, 3340, 3352, 3365,
                3379, 3394, 3409, 3423, 3438, 3453, 3468, 3482, 3495, 3509, 3523, 3536, 3549, 3562, 3576, 3589, 3601, 3613, 3626, 3640, 3655, 3669, 3683, 3698,
                3714, 3730, 3747, 3765, 3784, 3803, 3822, 3840, 3859, 3877, 3896, 3914, 3933, 3953, 3972, 3992, 4012, 4032, 4053, 4075, 4098, 4120, 4141, 4161,
                4182, 4204, 4227, 4249, 4270, 4292, 4313, 4335, 4356, 4377, 4398, 4419, 4439, 4459, 4479, 4498, 4518, 4538, 4558, 4577, 4597, 4616, 4634, 4651,
                4668, 4684, 4700, 4716, 4733, 4751, 4768, 4785, 4803, 4820, 4836, 4852, 4869, 4885, 4902, 4920, 4938, 4955, 4973, 4992, 5010, 5027, 5044, 5060,
                5075, 5090, 5104, 5119, 5133, 5147, 5160, 5173, 5186, 5200, 5214, 5228, 5243, 5259, 5275, 5290, 5304, 5318, 5333, 5347, 5361, 5374, 5386, 5398,
                5409, 5420, 5432, 5443, 5453, 5463, 5474, 5486, 5499, 5513, 5526, 5540, 5554, 5567, 5579, 5592, 5606, 5619, 5631, 5642, 5653, 5663, 5674, 5684,
                5695, 5707, 5718, 5728, 5738, 5749, 5759, 5769, 5778, 5787, 5797, 5808, 5820, 5833, 5847, 5860, 5873, 5887, 5902, 5916, 5931, 5947, 5962, 5976,
                5989, 6001, 6014, 6027, 6040, 6053, 6066, 6080, 6094, 6107, 6121, 6134, 6148, 6162, 6176, 6189, 6201, 6214, 6227, 6241, 6256, 6270, 6283, 6295,
                6308, 6322, 6337, 6351, 6365, 6378, 6391, 6403, 6415, 6426, 6436, 6445, 6454, 6464, 6475, 6487, 6499, 6512, 6524, 6536, 6548, 6560, 6572, 6585,
                6598, 6612, 6626, 6641, 6655, 6668, 6682, 6695, 6707, 6718, 6729, 6741, 6754, 6767, 6781, 6795, 6810, 6824, 6838, 6853, 6869, 6885, 6902, 6918,
                6935, 6953, 6970, 6988, 7005, 7022, 7039, 7055, 7070, 7086, 7102, 7118, 7134, 7150, 7167, 7184, 7200, 7215, 7230, 7245, 7260, 7274, 7287, 7299,
                7311, 7323, 7336, 7350, 7365, 7379, 7392, 7405, 7418, 7432, 7446, 7461, 7475, 7488, 7500, 7513, 7527, 7542, 7556, 7571, 7585, 7598, 7611, 7624,
                7637, 7649, 7661, 7673, 7686, 7700, 7713, 7727, 7742, 7756, 7771, 7786, 7800, 7814, 7827, 7839, 7852, 7866, 7881, 7895, 7909, 7924, 7938, 7953,
                7969, 7986, 8003, 8021, 8039, 8057, 8074, 8090, 8105, 8119, 8132, 8146, 8160, 8173, 8185, 8197, 8210, 8223, 8237, 8251, 8264, 8276, 8289, 8301,
                8313, 8324, 8336, 8348, 8361, 8375, 8388, 8400, 8413, 8427, 8442, 8456, 8471, 8486, 8500, 8515, 8529, 8542, 8554, 8565, 8575, 8585, 8595, 8604,
                8614, 8624, 8635, 8646, 8656, 8665, 8675, 8686, 8697, 8708, 8720, 8731, 8741, 8751, 8761, 8772, 8784, 8796, 8808, 8821, 8833, 8844, 8855, 8867,
                8879, 8892, 8904, 8917, 8929, 8942, 8956, 8971, 8986, 9001, 9015, 9029, 9043, 9056, 9070, 9083, 9095, 9107, 9118, 9129, 9141, 9154, 9167, 9179,
                9192, 9204, 9216, 9227, 9239, 9250, 9262, 9273, 9283, 9293, 9302, 9311, 9321, 9330, 9338, 9347, 9355, 9362, 9370, 9378, 9386, 9394, 9403, 9411,
                9420, 9428, 9436, 9443, 9450, 9457, 9463, 9470, 9478, 9485, 9493, 9502, 9510, 9517, 9523, 9528, 9534, 9540, 9547, 9555, 9562, 9569, 9576, 9584,
                9592, 9599, 9605, 9612, 9618, 9623, 9627, 9631, 9635, 9638, 9640, 9642, 9645, 9648, 9650, 9652, 9655, 9658, 9661, 9663, 9666, 9670, 9675, 9680,
                9684, 9687, 9690, 9692, 9693, 9695, 9696, 9697, 9698, 9699, 9701, 9704, 9707, 9710, 9712, 9714, 9717, 9721, 9725, 9729, 9732, 9736, 9740, 9743,
                9746, 9748, 9751, 9755, 9760, 9765, 9771, 9778, 9785, 9791, 9797, 9804, 9811, 9819, 9827, 9835, 9844, 9853, 9862, 9870, 9879, 9889, 9899, 9910,
                9920, 9930, 9939, 9947, 9956, 9965, 9975, 9986, 9996, 10006, 10017, 10027, 10038, 10050, 10063, 10076, 10088, 10100, 10111, 10121, 10132, 10143,
                10155, 10168, 10181, 10193, 10206, 10219, 10231, 10242, 10254, 10267, 10279, 10290, 10300, 10309, 10317, 10325, 10332, 10340, 10349, 10357, 10366,
                10374, 10383, 10391, 10398, 10404, 10409, 10413, 10418, 10424, 10429, 10433, 10437, 10440, 10442, 10443, 10444, 10446, 10449, 10451, 10453,
                10456, 10460, 10465, 10470, 10474, 10478, 10483, 10487, 10492, 10498, 10503, 10507, 10512, 10516, 10521, 10526, 10532, 10538, 10544, 10549,
                10554, 10560, 10567, 10573, 10580, 10587, 10595, 10604, 10613, 10623, 10633, 10644, 10656, 10668, 10681, 10694, 10706, 10717, 10727, 10737,
                10747, 10758, 10769, 10780, 10790, 10801, 10811, 10820, 10830, 10841, 10852, 10862, 10873, 10885, 10896, 10906, 10915, 10923, 10932, 10942,
                10952, 10963, 10973, 10984, 10994, 11005, 11017, 11029, 11041, 11053, 11064, 11074, 11084, 11094, 11104, 11114, 11125, 11135, 11146, 11156,
                11166, 11175, 11185, 11195, 11206, 11218, 11229, 11240, 11252, 11265, 11278, 11291, 11303, 11315, 11327, 11340, 11354, 11367, 11381, 11395,
                11408, 11422, 11437, 11452, 11468, 11484, 11499, 11513, 11527, 11540, 11553, 11565, 11578, 11591, 11605, 11619, 11634, 11648, 11663, 11678,
                11694, 11711, 11727, 11743, 11760, 11777, 11795, 11814, 11834, 11855, 11875, 11894, 11914, 11933, 11952, 11970, 11989, 12007, 12026, 12046,
                12065, 12085, 12106, 12127, 12149, 12170, 12191, 12213, 12236, 12258, 12280, 12301, 12322, 12342, 12363, 12383, 12404, 12426, 12447, 12467,
                12486, 12506, 12526, 12547, 12569, 12592, 12615, 12637, 12659, 12681, 12702, 12723, 12745, 12766, 12788, 12810, 12832, 12855, 12879, 12903,
                12927, 12952, 12978, 13005, 13032, 13059, 13086, 13114, 13143, 13171, 13200, 13228, 13255, 13282, 13308, 13335, 13363, 13390, 13418, 13446,
                13475, 13505, 13536, 13566, 13595, 13625, 13656, 13686, 13715, 13743, 13770, 13798, 13827, 13855, 13882, 13910, 13937, 13963, 13989, 14015,
                14042, 14069, 14095, 14122, 14149, 14176, 14203}));
    }

}