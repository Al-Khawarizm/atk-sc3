TestHoaRotationMatrix : UnitTest {
	var order, report, floatWithin;

	setUp {
		order = HoaTests.order;
		report = HoaTests.report;
		floatWithin = HoaTests.floatWithin;
	}

	test_initKeywords {
		var r123, t1, t2, within = 0.00000001;
		r123 = 3.collect{rrand(0,2pi)};

		t1 = HoaRotationMatrix(r123[0], r123[1], r123[2], \rtt);
		t2 = HoaRotationMatrix(r123[0], r123[1], r123[2], \yxz);
		this.assertArrayFloatEquals(
			t1.matrix.asArray.flat, t2.matrix.asArray.flat,
			"axes keyword rtt should be equal to yxz", within: floatWithin, report: report
		);

		t1 = HoaRotationMatrix(r123[0], r123[1], r123[2], \ypr);
		t2 = HoaRotationMatrix(r123[0], r123[1], r123[2], \xyz);
		this.assertArrayFloatEquals(
			t1.matrix.asArray.flat, t2.matrix.asArray.flat,
			"axes keyword rtt should be equal to yxz", within: floatWithin, report: report
		);

	}

	test_buildR1 {
		var r123, x, res, test, axes = 'xyz';

		r123 = [ -2.420257662452, -0.76733344238074, -0.49621582037497 ];
		x = HoaRotationMatrix(r123[0], r123[1], r123[2], axes, order);
		test = [\x,\y, \z].collect({|axis, i| x.buildR1(axis, r123[i])}).asArray.flat;
		res = [ 1, 0, 0, 0, -0.75092478677443, 0.66038773808103, 0, -0.66038773808103, -0.75092478677443, 0.71976439977468, 0, 0.69421841578641, 0, 1, 0, -0.69421841578641, 0, 0.71976439977468, 0.87939050642489, 0.47610118379371, 0, -0.47610118379371, 0.87939050642489, 0, 0, 0, 1 ];
		this.assertArrayFloatEquals(test, res, "buildR1 should match pre-computed result", within: floatWithin, report: report);

		r123 = [ 3.690416225243, 2.8572040005295, 3.8816200395237 ];
		x = HoaRotationMatrix(r123[0], r123[1], r123[2], axes, order);
		test = [\x,\y, \z].collect({|axis, i| x.buildR1(axis, r123[i])}).asArray.flat;
		res = [ 1, 0, 0, 0, -0.85313883605033, 0.52168393345271, 0, -0.52168393345271, -0.85313883605033, -0.9598333580597, 0, -0.28057071257677, 0, 1, 0, 0.28057071257677, 0, -0.9598333580597, -0.7384500924485, 0.67430813502641, 0, -0.67430813502641, -0.7384500924485, 0, 0, 0, 1 ];
		this.assertArrayFloatEquals(test, res, "buildR1 should match pre-computed result", within: floatWithin, report: report);

		r123 = [ -3.53433817416, 3.3213530311139, 0.28837190981326 ];
		x = HoaRotationMatrix(r123[0], r123[1], r123[2], axes, order);
		test = [\x,\y, \z].collect({|axis, i| x.buildR1(axis, r123[i])}).asArray.flat;
		res = [ 1, 0, 0, 0, -0.92386176012834, -0.38272633587533, 0, 0.38272633587533, -0.92386176012834, -0.98388656405172, 0, 0.17879381722669, 0, 1, 0, -0.17879381722669, 0, -0.98388656405172, 0.95870816132106, -0.28439173936033, 0, 0.28439173936033, 0.95870816132106, 0, 0, 0, 1 ];
		this.assertArrayFloatEquals(test, res, "buildR1 should match pre-computed result", within: floatWithin, report: report);

		r123 = [ 6.1976673762831, 3.6879684473061, 5.3881779247696 ];
		x = HoaRotationMatrix(r123[0], r123[1], r123[2], axes, order);
		test = [\x,\y, \z].collect({|axis, i| x.buildR1(axis, r123[i])}).asArray.flat;
		res = [ 1, 0, 0, 0, 0.99634556972933, 0.085413732389729, 0, -0.085413732389729, 0.99634556972933, -0.85441324535827, 0, 0.51959407825373, 0, 1, 0, -0.51959407825373, 0, -0.85441324535827, 0.62551305655076, 0.78021369898543, 0, -0.78021369898543, 0.62551305655076, 0, 0, 0, 1 ];
		this.assertArrayFloatEquals(test, res, "buildR1 should match pre-computed result", within: floatWithin, report: report);

		r123 = [ 3.5019013714256, 5.3703244257169, -0.31526001641654 ];
		x = HoaRotationMatrix(r123[0], r123[1], r123[2], axes, order);
		test = [\x,\y, \z].collect({|axis, i| x.buildR1(axis, r123[i])}).asArray.flat;
		res = [ 1, 0, 0, 0, -0.93578802574215, 0.35256314452536, 0, -0.35256314452536, -0.93578802574215, 0.61148456431314, 0, 0.79125636023148, 0, 1, 0, -0.79125636023148, 0, 0.61148456431314, 0.95071578940535, 0.310063683419, 0, -0.310063683419, 0.95071578940535, 0, 0, 0, 1 ];
		this.assertArrayFloatEquals(test, res, "buildR1 should match pre-computed result", within: floatWithin, report: report);

		r123 = [ -3.8217768124588, 5.345347802986, -3.0429909451529 ];
		x = HoaRotationMatrix(r123[0], r123[1], r123[2], axes, order);
		test = [\x,\y, \z].collect({|axis, i| x.buildR1(axis, r123[i])}).asArray.flat;
		res = [ 1, 0, 0, 0, -0.77745690775396, -0.6289362102675, 0, 0.6289362102675, -0.77745690775396, 0.59153298563725, 0, 0.80628079904155, 0, 1, 0, -0.80628079904155, 0, 0.59153298563725, -0.99514278873123, 0.098442013572594, 0, -0.098442013572594, -0.99514278873123, 0, 0, 0, 1 ];
		this.assertArrayFloatEquals(test, res, "buildR1 should match pre-computed result", within: floatWithin, report: report);

		r123 = [ 1.9371480900392, 5.3346249177519, 2.2358504017209 ];
		x = HoaRotationMatrix(r123[0], r123[1], r123[2], axes, order);
		test = [\x,\y, \z].collect({|axis, i| x.buildR1(axis, r123[i])}).asArray.flat;
		res = [ 1, 0, 0, 0, -0.3582116821381, -0.9336403969301, 0, 0.9336403969301, -0.3582116821381, 0.58285348785704, 0, 0.81257726506031, 0, 1, 0, -0.81257726506031, 0, 0.58285348785704, -0.6171016842928, -0.78688341655101, 0, 0.78688341655101, -0.6171016842928, 0, 0, 0, 1 ];
		this.assertArrayFloatEquals(test, res, "buildR1 should match pre-computed result", within: floatWithin, report: report);

		r123 = [ -0.83573490405617, 5.8700351456799, -5.6816326439709 ];
		x = HoaRotationMatrix(r123[0], r123[1], r123[2], axes, order);
		test = [\x,\y, \z].collect({|axis, i| x.buildR1(axis, r123[i])}).asArray.flat;
		res = [ 1, 0, 0, 0, 0.67063271964944, 0.74178956270333, 0, -0.74178956270333, 0.67063271964944, 0.91586059060647, 0, 0.40149642411107, 0, 1, 0, -0.40149642411107, 0, 0.91586059060647, 0.82445792082332, -0.56592326051479, 0, 0.56592326051479, 0.82445792082332, 0, 0, 0, 1 ];
		this.assertArrayFloatEquals(test, res, "buildR1 should match pre-computed result", within: floatWithin, report: report);

		r123 = [ -2.8821686390354, 0.58776930653944, 5.1870122235364 ];
		x = HoaRotationMatrix(r123[0], r123[1], r123[2], axes, order);
		test = [\x,\y, \z].collect({|axis, i| x.buildR1(axis, r123[i])}).asArray.flat;
		res = [ 1, 0, 0, 0, -0.96653789247818, 0.2565238827163, 0, -0.2565238827163, -0.96653789247818, 0.83217968158965, 0, -0.55450606628724, 0, 1, 0, 0.55450606628724, 0, 0.83217968158965, 0.45700336760529, 0.88946496389539, 0, -0.88946496389539, 0.45700336760529, 0, 0, 0, 1 ];
		this.assertArrayFloatEquals(test, res, "buildR1 should match pre-computed result", within: floatWithin, report: report);

		r123 = [ 5.6098246663661, -2.8950501827806, -6.231897318669 ];
		x = HoaRotationMatrix(r123[0], r123[1], r123[2], axes, order);
		test = [\x,\y, \z].collect({|axis, i| x.buildR1(axis, r123[i])}).asArray.flat;
		res = [ 1, 0, 0, 0, 0.78173033275623, 0.62361661848354, 0, -0.62361661848354, 0.78173033275623, -0.96976203498743, 0, 0.24405244415299, 0, 1, 0, -0.24405244415299, 0, -0.96976203498743, 0.99868505939649, -0.051265506319771, 0, 0.051265506319771, 0.99868505939649, 0, 0, 0, 1 ];
		this.assertArrayFloatEquals(test, res, "buildR1 should match pre-computed result", within: floatWithin, report: report);

	}

	test_eulerToR3 {
		var r1, r2, r3, x, res, test, axes = 'xyz', order = 3, within = 0.00000001;

		#r1,r2,r3 = [ 4.7864320159343, -2.6168319075184, 5.9114735993464 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.eulerToR3(r1, r2, r3, axes, order).asArray.flat;
		res = [ -0.8063400783711, -0.43864312088774, 0.39674663263895, 0.31433852433757, 0.25039557075208, 0.91569282527768, -0.50100595817791, 0.86307257553789, -0.064021552813329 ];
		this.assertArrayFloatEquals(test, res, "eulerToR3 should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ -4.4787220612082, 5.5579419606946, -4.2459779273493 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.eulerToR3(r1, r2, r3, axes, order).asArray.flat;
		res = [ -0.33651532671078, -0.083362450371252, 0.93798088293783, 0.66840649250968, 0.6804888677247, 0.30027930610293, -0.6633175677303, 0.72800110080332, -0.17327493058576 ];
		this.assertArrayFloatEquals(test, res, "eulerToR3 should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ 4.6942778204965, -2.2261836263066, 3.986673755044 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.eulerToR3(r1, r2, r3, axes, order).asArray.flat;
		res = [ 0.40448490610647, 0.51253284057831, 0.75743121671922, 0.45589602549921, 0.60496503143698, -0.65282166375855, -0.79281194155112, 0.60936639066098, 0.01103753898101 ];
		this.assertArrayFloatEquals(test, res, "eulerToR3 should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ -2.7390065863441, 3.4309352856204, 4.1320349130054 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.eulerToR3(r1, r2, r3, axes, order).asArray.flat;
		res = [ 0.52552730300177, -0.70811347245605, 0.47158918978907, 0.80150625111302, 0.59796793733269, 0.0046984411083297, -0.28532224453491, 0.37551252448929, 0.88180585205885 ];
		this.assertArrayFloatEquals(test, res, "eulerToR3 should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ -3.0723103513838, 4.7280433741673, 3.3912959637178 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.eulerToR3(r1, r2, r3, axes, order).asArray.flat;
		res = [ -0.015168265450109, -0.17945198266629, 0.98364979013894, -0.0038683007184886, 0.98376613663847, 0.17941355760637, -0.9998774724799, -0.0010836607228137, -0.015616200134843 ];
		this.assertArrayFloatEquals(test, res, "eulerToR3 should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ -1.1135547038403, -2.3203496735004, 2.8884738393638 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.eulerToR3(r1, r2, r3, axes, order).asArray.flat;
		res = [ 0.6596026296598, 0.5253139681941, -0.5375589323656, -0.17061726132282, -0.59188611335515, -0.78775667496761, -0.73199325207584, 0.61132320718054, -0.30078200624028 ];
		this.assertArrayFloatEquals(test, res, "eulerToR3 should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ -5.6041890846043, 5.973378113095, 5.5366085423349 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.eulerToR3(r1, r2, r3, axes, order).asArray.flat;
		res = [ 0.69907312967181, 0.6690402828323, -0.25235264872502, -0.64679825638304, 0.44118557711604, -0.62209910953533, -0.30487501522873, 0.59811402465789, 0.74115507054652 ];
		this.assertArrayFloatEquals(test, res, "eulerToR3 should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ -1.0754074179384, 5.5926527701048, -4.0809851109648 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.eulerToR3(r1, r2, r3, axes, order).asArray.flat;
		res = [ -0.45504981639231, -0.052943409751016, -0.88889069067308, 0.62227578545277, -0.73293862359407, -0.27490693131159, -0.63694780903969, -0.67823150133856, 0.36646898798068 ];
		this.assertArrayFloatEquals(test, res, "eulerToR3 should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ 6.0410530311355, -1.0852195020797, 0.7834702012158 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.eulerToR3(r1, r2, r3, axes, order).asArray.flat;
		res = [ 0.3306555279166, -0.8353905929309, 0.43907798749284, 0.32938299702539, 0.53814446342032, 0.77582689935361, -0.88440588144175, -0.11190662952939, 0.45310389883404 ];
		this.assertArrayFloatEquals(test, res, "eulerToR3 should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ -4.8227007745823, 0.96971554244183, 2.5312585495817 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.eulerToR3(r1, r2, r3, axes, order).asArray.flat;
		res = [ -0.46343068015759, 0.60862233534822, 0.64405811663541, 0.32413096611479, -0.56002331438606, 0.76243885272823, 0.82472487624308, 0.56209673567752, 0.062258639934579 ];
		this.assertArrayFloatEquals(test, res, "eulerToR3 should match pre-computed result", within: floatWithin, report: report);

	}

	test_buildSHRotMtx {
		var r1, r2, r3, x, res, test, axes = 'xyz', order = 3, within = 0.00000001;

		#r1,r2,r3 = [ -1.5766910674202, 2.3862029893554, -3.1537581398968 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.matrix.asArray.flat;
		res = [
			[ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0.014234241281494, -0.99985946620127, -0.0088563097758047, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0.72799180711449, 0.0042913725859059, 0.68557239799711, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, -0.68543804617873, -0.016205923887077, 0.72795058409322, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.016432275924068, 0.68511103993551, 0.028065538844859, -0.7277047577502, 0.0033097346586161, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.0033112819709691, -0.72782841522758, -0.0074318307827884, -0.6855140576287, -0.016434052563822, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.86445112362424, 0.0054110723602852, -0.49997237618199, 0.0050957741797679, -0.051929098789969, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.06002465620687, -0.014739249857221, -0.0001204566122328, -0.00798642692055, 0.99805610946286, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.49883896322531, 0.025340397695173, -0.86555456325162, -0.020652176924317, 0.030105458567178, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0072698337734171, 0.61053845285123, -0.035282581884742, 0.78961335784159, 0.031412221159795, -0.036932016306087, 0.010253300638871 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.016748354915915, -0.059999366079082, 0.023299959947215, 0.00026931132062937, 0.012626848957814, -0.99763531653687, -0.011872063820905 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.0093859157492523, -0.7889989327943, -0.011367345261326, 0.61222999771305, -0.0051402092705432, 0.047286393469116, -0.013243007148767 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.50649718886116, 0.0082951007999419, -0.44576106690088, -0.0064368613053666, -0.41978698191712, -0.00049830128869168, -0.60698111052909 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.74334936042523, -0.01238133534945, 0.17121716119262, 0.0099231472819056, -0.18209008516921, 0.0075403008021736, 0.62020237866233 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.39200861892496, 0.00019735776253183, -0.57504321303613, -0.0083056891868219, -0.54183802953651, -0.032476970629392, 0.47004501756044 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.19183356179186, 0.030023534055703, 0.66286506382017, 0.038421556208996, -0.70417402234095, 0.0034554740642034, -0.15987235257344 ],
		].flat;
		this.assertArrayFloatEquals(test, res, "buildSHRotMtx should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ 6.2003818032241, 5.6478506119908, -2.9382173608897 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.matrix.asArray.flat;
		res = [
			[ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, -0.96612112198548, -0.20045580002592, -0.16256521734212, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, -0.066570181301734, 0.80211541974778, -0.5934469347501, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0.24935594762303, -0.56251962244779, -0.78828502823929, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.72104221210601, 0.49347724280611, 0.1953066049598, 0.2494624306666, 0.36905577483457, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.58416361443143, -0.76159627033787, -0.27849417720781, -0.011436187466499, 0.032158971678656, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.068426174105233, -0.092486263135332, 0.46508371989575, -0.82447859223007, 0.30115832093908, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.095503245531259, 0.23745928384638, -0.78151113311056, -0.29847003062863, 0.48440500435993, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.35362125038803, -0.33393219594156, 0.23923587864825, 0.41083865576771, 0.73308873479411, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.56356326181008, -0.40994043341832, -0.20396290919789, -0.14406930568256, -0.21561140711627, -0.43423697321844, -0.46576649732445 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.55415835290679, 0.26889976026962, 0.61398661419183, 0.3502989197851, 0.21057669466363, 0.18083348244926, -0.20944987589168 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.33773473551103, 0.72834758915838, -0.50870019442499, -0.27213808416368, 0.14844931912568, -0.014323239669479, 0.019174399408296 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.055370612798155, 0.12272813241019, -0.09037544236455, 0.087007758838207, -0.80566145681399, 0.54015292791028, -0.1589913882798 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.023653451201345, -0.15625992337795, 0.21329425800773, -0.7636746471672, 0.23252026180303, 0.45970232397137, -0.28449612396926 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.19724956709161, -0.11282362339106, -0.43804981679628, 0.42908978875328, 0.39144476929543, 0.32198091045324, -0.56165561990818 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.46766166834337, 0.42064595708131, 0.27765784408126, -0.087110283370715, -0.1753479794114, -0.41445051409029, -0.56316189536517 ],
		].flat;
		this.assertArrayFloatEquals(test, res, "buildSHRotMtx should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ 2.6197455721985, 0.36271904506986, 4.9258085515836 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.matrix.asArray.flat;
		res = [
			[ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, -0.01075457733433, -0.40619297878137, -0.91372403003044, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0.46604873328079, -0.81049552542391, 0.35481767356657, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, -0.88469368556226, -0.42202401265394, 0.19802226003591, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.80623623400496, 0.36389505332863, 0.29691367609092, 0.30517822994278, -0.19045220413432, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.42965584087386, -0.18058918642131, 0.57022159567537, 0.5964447900617, -0.31919327747364, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.28641595256107, -0.65424826679954, 0.48535449509827, -0.49809994402648, -0.07907317722878, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.22161693187911, 0.52035651700755, 0.59244550861225, -0.31023773405253, 0.48257216911814, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.18501575879773, 0.36899354534763, 0.011354919140903, -0.45471843431734, -0.78912302196272, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.25284230644667, -0.32467857750613, -0.29381907705304, -0.11859744285241, 0.054135490495169, 0.49101446801899, 0.69730461546785 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.24165056047534, -0.38210653636149, -0.34001402568174, -0.53810351100758, -0.29491656348477, 0.093050460178492, -0.54295534596842 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.29164446526711, 0.44440297531738, 0.377436355769, -0.56825341829939, -0.2298235093694, 0.43836855671989, 0.084223003766444 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.05912983406339, -0.51907824425878, 0.65199006288943, -0.11529906058661, 0.49638070180865, 0.14330614491568, -0.14746549183964 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.14162390869011, 0.17366068153329, -0.10674573371406, -0.59040062315826, 0.41650840311252, -0.58795588997996, 0.26579260760873 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.53082481423956, 0.068958925646779, -0.46803655934293, -0.020578782147631, 0.58640226713819, 0.30626956691942, -0.23731689674169 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.69806205194828, 0.49671805111929, -0.0076612654912992, 0.10572159244327, 0.3058333760336, 0.31312870386183, -0.25131884160571 ],
		].flat;
		this.assertArrayFloatEquals(test, res, "buildSHRotMtx should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ 1.665468707491, 5.4579995170964, 2.5494580931286 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.matrix.asArray.flat;
		res = [
			[ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0.48664705031342, 0.78727343422832, 0.37864916239124, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0.67538245856348, -0.064131781201848, -0.73467383872343, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, -0.55410575081476, 0.613259858786, -0.56292020972407, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.48375513804621, -0.13779163601577, 0.83623966397122, -0.2109617948485, 0.056504663290585, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.10179385432839, 0.50050112541762, -0.087449942131014, -0.60267264128424, -0.60685651495673, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.85941905619227, -0.075021148116818, -0.49383067195982, 0.08160720518216, 0.072403347180138, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.026900563791297, 0.44972073993912, -0.068120600582283, -0.41444489886518, 0.78779605566242, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.12764882747661, -0.7229351090545, -0.2110606150626, -0.6433167947666, 0.051648071414479, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.15723724404969, -0.24026196979244, -0.63289358633045, 0.31646478517027, -0.61565003576635, 0.092239451019511, -0.17121127363738 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.48201610622412, -0.01022390682361, 0.5295449482195, -0.11991929516846, -0.53944270188678, 0.24442642084411, 0.34930610029847 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.32443493819529, -0.60732443086692, -0.20440873865573, -0.47219034673847, 1.7208574363839e-05, 0.11357077630717, 0.49825096992522 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.62101938142759, 0.1232432900677, -0.40508045035555, 0.095538255142713, 0.44064219566424, -0.010382858809216, 0.48130545553916 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.49603282275651, -0.48385382621489, 0.069271674252525, -0.36782059799183, 0.21007180922849, -0.039350148722567, -0.57798594897072 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.072135087904338, 0.088450286557963, -0.056820157700529, 0.030266730085407, 0.20678354330386, 0.95757342764607, -0.15205974981741 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.027600525990461, 0.56231646462752, -0.32423395461154, -0.71914536318299, -0.22118196384923, -0.015690122452105, -0.10757812411663 ],
		].flat;
		this.assertArrayFloatEquals(test, res, "buildSHRotMtx should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ 3.2031331465069, -5.3892175562802, 3.5041559037359 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.matrix.asArray.flat;
		res = [
			[ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0.91621628665158, -0.33346924985161, -0.22213954055459, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, -0.038519953896997, -0.62513821042268, 0.77956297437814, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, -0.39882819512438, -0.70569148873494, -0.58560702992783, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.44794718637239, -0.51356909628255, 0.40759730086453, 0.35204392005872, 0.49549936452252, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.72280509845666, -0.55991658966713, 0.36107088055199, -0.12109236543155, -0.13787915184023, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.052011285757259, 0.041708294478727, 0.086196673195713, -0.84408829218797, 0.5250146025081, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.28835413826245, 0.27650594777774, 0.76410237930171, -0.18404562525152, -0.47188040175631, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.43708445976368, 0.58697962057832, 0.33497753211344, 0.3391811908123, 0.48698898636126, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.20689770189347, 0.20864544186211, 0.16138884885861, -0.36454829815794, -0.3500604666274, -0.62714963925896, -0.48873264470217 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.45106086449464, -0.13389126536439, 0.49329460722456, -0.56976051220159, -0.05790818028996, -0.055097838482188, 0.45195296840436 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.55072195660657, -0.6986094758338, 0.19843994949424, -0.19481157290367, 0.35329809640824, -0.02353806556068, -0.077114063815527 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.055474811177053, 0.072704055572655, -0.022503222741498, 0.32695075023853, 0.45541797117321, -0.73389246740313, 0.37179267789225 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.20005256275491, 0.31852391009081, -0.13760256699928, -0.41226250686192, 0.72010405011637, 0.12820372578947, -0.3669340697271 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.39433853824473, 0.17128413810434, -0.591967506571, -0.46824885706593, -0.096873428574287, -0.017411897543528, 0.48558079139277 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.50183802038013, -0.56071685542894, -0.56689440469769, -0.091715801907707, -0.11808867350073, -0.21853144956319, -0.20560453712007 ],
		].flat;
		this.assertArrayFloatEquals(test, res, "buildSHRotMtx should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ 5.6127563073836, 6.2568859256248, 6.2644404813995 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.matrix.asArray.flat;
		res = [
			[ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0.78372378113538, 0.62082682809527, -0.018737246329681, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, -0.62110733053534, 0.7832842306173, -0.026296349965696, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, -0.0016488899644551, 0.032246915874587, 0.99947857284609, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.78334602193217, 0.024248999712675, 0.034675225017864, 0.61989889372312, -0.017435201943037, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.0089712337757633, 0.22827838500013, 0.84226836002647, -0.031002069114918, 0.48726930676494, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.028289335957082, -0.8426489143445, 0.42030127890061, -0.035675944656326, -0.33349150296901, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.62074010852015, -0.021320345344043, 0.043749006519144, 0.78202782876508, -0.027306775978945, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.013036795353109, -0.48660992076108, -0.33288811611619, 0.043862686663116, 0.80641328972874, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.70736365585655, 0.040850245251044, -0.29175042006095, -0.18763852370002, 0.045721498023944, 0.61247136238788, -0.020730835181126 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.011965768907053, 0.22792117883133, 0.010371393656915, 0.060732851646059, 0.76690068644901, -0.014896565512608, 0.59645128971201 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.29280783117399, 0.0049218465381399, -0.34996546245014, 0.78608142078959, -0.041654341586236, 0.41447260485845, -0.017801687004067 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.18840753229771, 0.049548115202189, -0.78643658868287, 0.026502786040352, -0.03329603555638, -0.58410262556634, 0.024045315324932 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.032226743788279, -0.76794213899758, -0.040072940304601, 0.04083055096789, 0.51498768154073, -0.043636006381883, -0.37260826682721 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.61385685810856, -0.0042358552324474, -0.4139126878815, -0.58304580750103, 0.062314145913983, 0.32826039574988, -0.016054539883432 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.020021220299675, -0.59510577386874, -0.029769782109378, -0.029450973485855, -0.37125975632439, 0.045105617701034, 0.70980725937783 ],
		].flat;
		this.assertArrayFloatEquals(test, res, "buildSHRotMtx should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ -4.6467873332528, -5.7886382901227, 1.3001430935042 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.matrix.asArray.flat;
		res = [
			[ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, -0.47389763074897, -0.23680414523384, 0.84814198833131, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0.87829051093441, -0.057700100192663, 0.47463299173185, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, -0.063457182202522, 0.96984251053345, 0.2353267744841, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.16534150156696, -0.44457914415102, -0.39778751128093, 0.76683779956972, 0.16951831011876, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.51998761001942, -0.18063889293354, 0.023666089088707, -0.16133293761116, 0.81877596157621, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.72203249060507, -0.087775919027996, -0.49500604765663, -0.047434586314666, -0.47295184041712, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.17656640076253, 0.85546495987337, -0.09692558056209, 0.44674087381747, 0.1674276919871, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.38699930480336, -0.17376439627652, 0.76601531101684, 0.42907344834512, -0.22170699556255, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.19181517161617, -0.30863357231551, -0.37763875005797, -0.51776837724598, 0.62171600172015, 0.26565597959646, 0.012379566475049 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.086234031232289, 0.47203465474435, -0.27837266576643, 0.051323080262442, -0.24231288553286, 0.74465493917168, 0.2763965702324 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.93525424681964, -0.20352237472767, 0.14650379839263, 0.14259838229567, -0.19229283097992, 0.027540304371789, -0.06592020936762 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.066355375936067, -0.093157604038615, -0.52888772669587, 0.086069897704711, -0.28581381773651, 0.061020883204286, -0.78382095121118 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.22352380407138, 0.62313650890026, -0.10727265406958, -0.58401837918451, -0.124253518817, -0.43399841255419, -0.07320895925135 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.013521811151806, 0.27204692425258, 0.63001778657263, -0.098832326743943, 0.2927529150403, 0.36906055070604, -0.54516734317854 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.16285379738324, 0.41172839206867, -0.2651079201132, 0.59219441655362, 0.57874381314314, -0.21418121610669, -0.046518178747383 ],
		].flat;
		this.assertArrayFloatEquals(test, res, "buildSHRotMtx should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ -4.1430589018903, -5.706149372071, -3.4045235519571 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.matrix.asArray.flat;
		res = [
			[ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0.40111463078819, 0.88975171291771, 0.21782778134951, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0.70588600907478, -0.45178384923198, 0.54554220346881, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0.58380818353302, -0.065063376281352, -0.80928039757969, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.19744456652662, 0.49334645915896, -0.10026885511944, -0.73423123087973, -0.41045775748341, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.37258654276619, 0.44684617381818, -0.6962419092433, 0.38698603647754, -0.16430695809445, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.66699649993925, -0.55236468278855, -0.1938370303597, -0.42689363763107, -0.17377558542024, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.25276770722225, -0.30968243538986, 0.050912910496563, 0.33012499546489, -0.85359864005907, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.5598384289713, -0.39487696134149, -0.68192993900575, -0.14115812655194, 0.21377338572566, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.058020655362069, -0.59433291252288, -0.37126538327696, -0.54792749800582, -0.075352882148141, 0.26566063926674, 0.35928516898013 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.48677574590456, -0.15993997262531, -0.41702517702967, 0.10129354245884, 0.47455073392108, -0.56336230107366, -0.10355055286738 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.084508206732078, 0.27560269063443, -0.70731207419269, 0.01119317361968, -0.54711771524127, -0.023775598242474, -0.34144221923032 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.2201926710072, -0.67381280264956, 0.0088801230057398, 0.44714329898732, 0.0068629804378402, 0.17555146729367, -0.51634299650226 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.71692677500648, 0.14094441116162, 0.054871388224338, -0.00081850437197989, 0.035933654610105, 0.62007497398826, -0.2781275465427 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.18924249242497, -0.062137633800887, -0.1573502958667, 0.68889885247368, -0.23877376239856, 0.10515104385376, 0.62682995887562 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.3927592210498, 0.25977037086092, -0.40014098161175, 0.12194408280565, 0.64143161140687, 0.43024880051263, 0.082023421972272 ],
		].flat;
		this.assertArrayFloatEquals(test, res, "buildSHRotMtx should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ 4.4202375456419, 3.7802919199208, -6.261191258422 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.matrix.asArray.flat;
		res = [
			[ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, -0.30049868480868, 0.95361877682077, -0.017656979444941, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0.76885134055538, 0.23123766545711, -0.59615162349871, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, -0.56441842329468, -0.19271837112432, -0.80267768928552, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.25116951445403, -0.48032838937605, -0.31831605032491, -0.76204569192017, -0.15543413042121, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.16556718649152, 0.66370446058934, 0.38193899172786, -0.57258434070642, 0.24156505361247, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.79388890827849, 0.30793679082048, -0.41979371311092, -0.2387678971204, -0.20415304041041, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.28066085806136, -0.27868657653223, -0.077186672645073, -0.070719945161098, 0.91247146899802, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.44774017669945, 0.39533498741341, -0.75538927362121, 0.17152876395757, 0.20785550348546, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.092122161593344, 0.4636497797772, 0.45465626556021, -0.60158928583713, 0.30057570623943, 0.27944994351589, 0.19870172192603 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.32975135431877, -0.24147145050188, -0.39903106592399, -0.16458949614976, -0.10538765664025, 0.78765367704603, -0.12302526555932 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.084261079086613, -0.63057030854918, 0.4788932493555, -0.42784300784942, -0.32541325339526, -0.089400784065905, -0.26269085862771 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.28875460615556, -0.41049069086861, -0.34494672098313, -0.31594530729364, 0.2674646409358, -0.10556001189476, 0.668302508116 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.84128105585032, 0.037051592111045, 0.017722444098351, 0.086463489996031, 0.21343646562586, 0.36953280246235, -0.31776363465281 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.13118371007343, -0.00026508126842381, -0.38563713061587, -0.39058394892542, 0.47380415841869, -0.35814696477289, -0.57337537212946 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.25949069139792, -0.39903133742282, 0.36973615252591, 0.40999731230358, 0.67161824097968, 0.13247738422203, 0.0038256116660192 ],
		].flat;
		this.assertArrayFloatEquals(test, res, "buildSHRotMtx should match pre-computed result", within: floatWithin, report: report);

		#r1,r2,r3 = [ -2.9627206067368, 6.1923508745094, 3.8503262322396 ];
		x = HoaRotationMatrix(r1, r2, r3, axes, order);
		test = x.matrix.asArray.flat;
		res = [
			[ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0.75757839360144, -0.076975895643257, -0.64818954715282, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, -0.17718623629261, -0.97998816879513, -0.090709573309699, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, -0.62823563669751, 0.18356987909645, -0.75605693189851, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, -0.16555662308269, 0.1874275749293, -0.024474667477695, -0.060789917312247, 0.96600594476152, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.046130653431985, -0.72877879342995, 0.13065806155886, 0.64220053799537, 0.19302946150488, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.027838365630302, 0.3007540214432, 0.94056521646765, 0.15396945906812, -0.020062981588308, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.19094986872881, 0.58313743520524, -0.31158954842817, 0.72427530279074, -0.042733106280968, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0.9660363038721, -0.057009864505193, 0.024051787522665, -0.18868425051733, 0.16535870123432, 0, 0, 0, 0, 0, 0, 0 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.49130579117419, -0.12829535535635, 0.037562557577117, -0.0057914536741761, 0.0032580905066544, 0.20159418202264, -0.83669803711146 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.19123826185866, 0.1560131931915, -0.28645979751934, 0.053631832316105, 0.096220468139122, -0.90795058281195, -0.14324657902228 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.037167719528676, -0.073435500806472, 0.6866409875336, -0.1792128939013, -0.63319217352989, -0.29768883163328, -0.0090394494328758 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.00093996304731929, -0.061002771898717, -0.41251950237306, -0.88291252766746, -0.21118721648557, 0.04396441607576, 0.0061641424451492 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.0094396831629136, -0.29121128395567, -0.51743188738911, 0.4273817016492, -0.67781440477041, 0.062852768499004, 0.036512541198858 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.14320700118916, -0.90810055574067, 0.08444630131022, -0.052705166944301, 0.29037411003784, -0.1550354662855, 0.19126683836896 ],
			[ 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.83669998867377, 0.20158234830097, 0.0038362979772911, 0.0023106810585383, -0.038067653412996, 0.12824799519538, 0.49130533771745 ],
		].flat;
		this.assertArrayFloatEquals(test, res, "buildSHRotMtx should match pre-computed result", within: floatWithin, report: report);

	}
}

/* loops to generate code for tests */
/*

// test for buildSHRotMtx
(
var r1, r2, r3, axes = 'xyz';
10.do{
#r1,r2,r3 = 3.collect{rrand(-2pi,2pi)};
x = HoaRotationMatrix(r1, r2, r3, axes, 3);
postf("#r1,r2,r3 = %;\n", [r1,r2,r3]);
	"x = HoaRotationMatrix(r1, r2, r3, axes, order);".postln;
	"test = x.matrix.asArray.flat;".postln;
	"res = [".postln;
	x.matrix.asArray.do{|me| me.post; ",".postln};
	"].flat;".postln;
	"this.assertArrayFloatEquals(test, res, \"buildSHRotMtx should match pre-computed result\", within: floatWithin, report: report);\n".postln;
};
nil
)

// test for eulerToR3
(
var r1, r2, r3, axes = 'xyz';
10.do{
#r1,r2,r3 = 3.collect{rrand(-2pi,2pi)};
x = HoaRotationMatrix(r1, r2, r3, axes);
x.eulerToR3(r1, r2, r3, axes);
postf("#r1,r2,r3 = %;\n", [r1,r2,r3]);
	"x = HoaRotationMatrix(r1, r2, r3, axes);".postln;
	"test = x.eulerToR3(r1, r2, r3, axes).asArray.flat;".postln;
	postf("res = %;\n", x.eulerToR3(r1, r2, r3, axes).asArray.flat);

	"this.assertArrayFloatEquals(test, res, \"eulerToR3 should match pre-computed result\", within: floatWithin, report: report);\n".postln;
};
nil
)

// test for buildR1
(
var r123, x,res, axes = 'xyz';
10.do{
	r123 = 3.collect{rrand(-2pi,2pi)};
	x = HoaRotationMatrix(r123[0], r123[1], r123[2], axes);
	res = [\x,\y, \z].collect({|axis, i| x.buildR1(axis, r123[i])}).asArray.flat;

	postf("r123 = %;\n", r123);
	"x = HoaRotationMatrix(r123[0], r123[1], r123[2], axes);".postln;
	"test = [\\x,\\y, \\z].collect({|axis, i| x.buildR1(axis, r123[i])}).asArray.flat;".postln;
	postf("res = %;\n", res);

	"this.assertArrayFloatEquals(test, res, \"buildR1 should match pre-computed result\", within: floatWithin, report: report);\n".postln;
};
nil
)
*/