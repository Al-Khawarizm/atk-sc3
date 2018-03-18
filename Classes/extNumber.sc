/*
	Copyright the ATK Community, Joseph Anderson, and Michael McCrea, 2018
		J Anderson	j.anderson[at]ambisonictoolkit.net


	This file is part of SuperCollider3 version of the Ambisonic Toolkit (ATK).

	The SuperCollider3 version of the Ambisonic Toolkit (ATK) is free software:
	you can redistribute it and/or modify it under the terms of the GNU General
	Public License as published by the Free Software Foundation, either version 3
	of the License, or (at your option) any later version.

	The SuperCollider3 version of the Ambisonic Toolkit (ATK) is distributed in
	the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
	implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See
	the GNU General Public License for more details.

	You should have received a copy of the GNU General Public License along with the
	SuperCollider3 version of the Ambisonic Toolkit (ATK). If not, see
	<http://www.gnu.org/licenses/>.
*/


//---------------------------------------------------------------------
//	The Ambisonic Toolkit (ATK) is a soundfield kernel support library.
//
// 	Class: LegendreP
//
//	The Ambisonic Toolkit (ATK) is intended to bring together a number of tools and
//	methods for working with Ambisonic surround sound. The intention is for the toolset
//	to be both ergonomic and comprehensive, providing both classic and novel algorithms
//	to creatively manipulate and synthesise complex Ambisonic soundfields.
//
//	The tools are framed for the user to think in terms of the soundfield kernel. By
//	this, it is meant the ATK addresses the holistic problem of creatively controlling a
//	complete soundfield, allowing and encouraging the composer to think beyond the placement
//	of sounds in a sound-space and instead attend to the impression and image of a soundfield.
//	This approach takes advantage of the model the Ambisonic technology presents, and is
//	viewed to be the idiomatic mode for working with the Ambisonic technique.
//
//
//	We hope you enjoy the ATK!
//
//	For more information visit http://ambisonictoolkit.net/ or
//	email info[at]ambisonictoolkit.net
//
//---------------------------------------------------------------------


+ Number {

	/*	Factorials and Binomial Coefficients */

	// TODO: replace Integer:factorial?
	factorial { _Factorial; ^this.primitiveFailed }

	// TODO: overflow_error handling?
	// factorial {
	//     if (this > 170) {
	//         format("Resolution is too low for this factorial: % (max 170)", this).throw;
	//     } {
	//         ^prFactorial(this)
	//     }
	// }
	//
	// prCheckFactorialRes {
	//
	// }

	doubleFactorial { _DoubleFactorial; ^this.primitiveFailed }
	// both x and i can be negative as well as positive
	risingFactorial { |i| _RisingFactorial; ^this.primitiveFailed }
	// only defined for positive i, x can be either positive or negative
	fallingFactorial { |i| _FallingFactorial; ^this.primitiveFailed }
	// Requires k <= n
	binomialCoefficient { |k| _BinomialCoefficient; ^this.primitiveFailed }

	/* Chebyshev polynomials */
	// Chebyshev first kind
	chebyshev { |x| _ChebyshevT; ^this.primitiveFailed }
	// Chebyshev Second kind
	chebyshev2 { |x| _ChebyshevU; ^this.primitiveFailed }
	// Chebyshev derivative
	chebyshevPrime { |x| _ChebyshevTPrime; ^this.primitiveFailed }

	// calculate the roots (zeros) of Chebyshev polynomial
	// "https://en.wikipedia.org/wiki/Chebyshev_polynomials#Roots_and_extrema"
	// "http://mathworld.wolfram.com/ChebyshevPolynomialoftheFirstKind.html"
	chebyZeros {
		var n = this.asInt;
		^(1..n).collect({ arg k;
			cos(pi* ((2*k) - 1) / (2*n))
		});
	}

	chebyMaxZero {
		var n = this.asInt;
		^cos(pi * (2*n).reciprocal)
	}


	/*	Legendre (and Associated) Polynomials

	The definition of the associated Legendre polynomial used here includes a leading Condon-Shortley phase term
	of (-1)m. This matches the definition given by Abramowitz and Stegun (8.6.6) and that used by Mathworld and
	Mathematica's LegendreP function. However, uses in the literature do not always include this phase term, and
	strangely the specification for the associated Legendre function in the C++ TR1 (assoc_legendre) also omits it,
	in spite of stating that it uses Abramowitz and Stegun as the final arbiter on these matters.

	See:
	Weisstein, Eric W. "Legendre Polynomial." From MathWorld--A Wolfram Web Resource.

	Abramowitz, M. and Stegun, I. A. (Eds.). "Legendre Functions" and "Orthogonal Polynomials." Ch. 22 in Chs. 8
	and 22 in Handbook of Mathematical Functions with Formulas, Graphs, and Mathematical Tables, 9th printing.
	New York: Dover, pp. 331-339 and 771-802, 1972.

	"http://www.boost.org/doc/libs/1_65_1/libs/math/doc/html/math_toolkit/sf_poly/legendre.html"
	*/

	// TODO: where to clip values at [-1,1] ??
	legendre { |x| _LegendreP; ^this.primitiveFailed }
	legendrePrime { |x| _LegendrePPrime; ^this.primitiveFailed }
	legendreZeros { _LegendrePZeros; ^this.primitiveFailed }
	legendreAssoc { |m, x| _LegendrePAssoc; ^this.primitiveFailed }
	// TODO: proper way to catch error?
	legendre2 { |x|
		if (this < 0) {
			format("n = %, but Legendre Polynomial of the Second Kind requires n >= 0", this).throw
		};
		^prLegendre2(this, x)
	}
	// TODO: name?
	prLegendre2 { |x| _LegendreQ; ^this.primitiveFailed }


	/*	Bessel Functions  */
	//  First and Second Kinds
	bessel { |x| _BesselJ; ^this.primitiveFailed }
	bessel2 { |x| _BesselNeumann; ^this.primitiveFailed }
	//  Modified, First and Second Kinds
	besselMod { |x| _BesselI; ^this.primitiveFailed }
	besselMod2 { |x| _BesselK; ^this.primitiveFailed }
	// Spherical, First and Second Kinds
	besselSph { |x| _BesselSph; ^this.primitiveFailed }
	besselSph2 { |x| _BesselNeumannSph; ^this.primitiveFailed }
	// Derivatives
	besselPrime { |x| _BesselJPrime; ^this.primitiveFailed }
	besselPrime2 { |x| _BesselNeumannPrime; ^this.primitiveFailed }
	besselModPrime { |x| _BesselIPrime; ^this.primitiveFailed }
	besselModPrime2 { |x| _BesselKPrime; ^this.primitiveFailed }
	besselSphPrime { |x| _BesselSphPrime; ^this.primitiveFailed }
	besselSphPrime2 { |x| _BesselNeumannSphPrime; ^this.primitiveFailed }
	// Zero finder for bessel polynomials of first and second kind
	// Retrieve one zero at a time, by index
	besselZero { |index| _BesselZero; ^this.primitiveFailed }
	besselZero2 { |index| _BesselNeumannZero; ^this.primitiveFailed }


	/*  Laguerre polynomial  */
	laguerre { |x| _Laguerre; ^this.primitiveFailed }
	// TODO: proper way to catch error?
	laguerreAssoc { |m, x|
		if (this < 0) {
			format("n = %, but Associated Laguerre Polynomial requires n >= 0", this).throw
		};
		^prLaguerreAssoc(this, m, x);
	}
	prLaguerreAssoc { |m, x| _LaguerreAssoc; ^this.primitiveFailed }


	/*  Hermite Polynomial  */
	// TODO: proper way to catch error?
	hermite { arg x;
		if (this < 0) {
			format("n = %, but Hermite Polynomial requires n >= 0", this).throw
		};
		^prHermite(this, x);
	}
	prHermite { |x| _Hermite; ^this.primitiveFailed }


	/*  Hankel Functions  */
	// Cyclic
	hankelCyc { |x| _CycHankel1; ^this.primitiveFailed }
	hankelCyc2 { |x| _CycHankel2; ^this.primitiveFailed }
	// Spherical
	hankelSph { |x| _SphHankel1; ^this.primitiveFailed }
	hankelSph2 { |x| _SphHankel2; ^this.primitiveFailed }



	/* Beta functions */
	beta { |z| _Beta; ^this.primitiveFailed }
	// incomplete beta functions
	// All require 0 <= x <= 1
	// normalised incomplete beta function of a, b and x
	// require a,b >= 0, and in addition that not both a and b are zero
	betaI { |b, x| _BetaI; ^this.primitiveFailed }
	// normalised complement of the incomplete beta function of a, b and x
	// require a,b >= 0, and in addition that not both a and b are zero
	betaIC { |b, x| _BetaIC; ^this.primitiveFailed }
	// full (non-normalised) incomplete beta function of a, b and x
	// require a,b > 0
	betaIFull { |b, x| _BetaIFull; ^this.primitiveFailed }
	// full (non-normalised) complement of the incomplete beta function of a, b and x
	// require a,b > 0
	betaIFullC { |b, x| _BetaIFullC; ^this.primitiveFailed }
	// Incomplete beta function inverses
	// Requires: a,b > 0 and 0 <= p <= 1
	betaIInv { |b, p| _BetaIInv; ^this.primitiveFailed }
	// Requires: a,b > 0 and 0 <= q <= 1
	betaICInv { |b, q| _BetaICInv; ^this.primitiveFailed }
	// Requires: b > 0, 0 < x < 1 and 0 <= p <= 1
	betaIInvA { |x, p| _BetaIInvA; ^this.primitiveFailed }
	// Requires: b > 0, 0 < x < 1 and 0 <= q <= 1
	betaICInvA { |x, q| _BetaICInvA; ^this.primitiveFailed }
	// Requires: a > 0, 0 < x < 1 and 0 <= p <= 1
	betaIInvB { |x, p| _BetaIInvB; ^this.primitiveFailed }
	// Requires: a > 0, 0 < x < 1 and 0 <= q <= 1
	betaICInvB { |x, q| _BetaICInvB; ^this.primitiveFailed }
	// Incomplete beta function derivative
	betaIDerivative { |b, x| _BetaIDerivative; ^this.primitiveFailed }



	/*  Error functions */
	// error function of z
	errorFunc { _Erf; ^this.primitiveFailed }
	// complement of error function
	errorFuncC { _ErfC; ^this.primitiveFailed }
	// inverse error function of z
	errorFuncInv { _ErfInv; ^this.primitiveFailed }
	// inverse of the complement of the error function of z
	errorFuncCInv { _ErfCInv; ^this.primitiveFailed }


	/*  Gamma  */
	// "true gamma" of input value
	gamma { _TGamma; ^this.primitiveFailed }
	// gamma(value + 1) - 1
	gamma1pm1 { _TGamma1pm1; ^this.primitiveFailed }
	// log gamma
	gammaLog { _LGamma; ^this.primitiveFailed }
	// digamma
	gammaDi { _DiGamma; ^this.primitiveFailed }
	// trigamma
	gammaTri { _TriGamma; ^this.primitiveFailed }
	// polygamma
	gammaPoly { |z| _PolyGamma; ^this.primitiveFailed }
	// gamma(value) / gamma(b)
	gammaRatio { |b| _TGammaRatio; ^this.primitiveFailed }
	// gamma(value) / gamma(value + delta)
	gammaDeltaRatio { |delta| _TGammaDeltaRatio; ^this.primitiveFailed }
	// normalised lower incomplete gamma function of a and z
	gammaP { |z| _GammaP; ^this.primitiveFailed }
	// normalised upper incomplete gamma function of a and z
	gammaQ { |z| _GammaQ; ^this.primitiveFailed }
	// full (non-normalised) lower incomplete gamma function of a and z
	gammaFullLower { |z| _TGammaLower; ^this.primitiveFailed }
	// full (non-normalised) upper incomplete gamma function of a and z
	gammaFullUpper { |z| _TGammaI; ^this.primitiveFailed }

	/* Incomplete Gamma Function Inverses */
	// Returns a value x such that: p = gammaP(a, x);
	// Requires: a > 0 and 1 >= p >= 0.
	gammaPInv { |p| _GammaPInv; ^this.primitiveFailed }
	// Returns a value x such that: q = gammaQ(a, x);
	// Requires: a > 0 and 1 >= q >= 0.
	gammaQInv { |q| _GammaQInv; ^this.primitiveFailed }
	// Returns a value a such that: p = gammaP(a, x);
	// Requires: x > 0 and 1 >= p >= 0.
	gammaPInvA { |p| _GammaPInvA; ^this.primitiveFailed }
	// Returns a value a such that: q = gammaQ(a, x);
	// Requires: x > 0 and 1 >= q >= 0.
	gammaQInvA { |q| _GammaQInvA; ^this.primitiveFailed }
	// Derivatives of the Incomplete Gamma Function
	gammaPDerivative { |x| _GammaPDerivative; ^this.primitiveFailed }
	gammaQDerivative { |x| ^this.gammaPDerivative(x).neg }


	/*  Airy Functions  */
	airyAi { _AiryAi; ^this.primitiveFailed }
	airyBi { _AiryBi; ^this.primitiveFailed }
	airyAiPrime { _AiryAiPrime; ^this.primitiveFailed }
	airyBiPrime { _AiryBiPrime; ^this.primitiveFailed }
	airyZero { _AiryZero; ^this.primitiveFailed }


	/*  Elliptic Integrals - Carlson Form  */
	// Requires that all of the arguments are non-negative, and at most one may be zero
	ellipIntRf { |y, z| _EllintRf; ^this.primitiveFailed }
	// Requires that x and y are non-negative, with at most one of them zero, and that z >= 0
	ellipIntRd { |y, z| _EllintRd; ^this.primitiveFailed }
	// Requires that x, y and z are non-negative, with at most one of them zero, and that p != 0
	ellipIntRj { |y, z, p| _EllintRj; ^this.primitiveFailed }
	// Requires that x > 0 and that y != 0
	ellipIntRc { |y| _EllintRc; ^this.primitiveFailed }
	// Requires that x and y are non-negative
	ellipIntRg { |y, z| _EllintRg; ^this.primitiveFailed }

	/*  Elliptic Integrals of the First, Second, Third Kind, D - Legendre Form  */
	// Requires -1 <= k <= 1
	ellipInt1i { |phi| _Ellint1Incomplete; ^this.primitiveFailed }
	// Requires -1 <= k <= 1
	ellipInt1c { _Ellint1Complete; ^this.primitiveFailed }
	// Requires -1 <= k <= 1
	ellipInt2i { |phi| _Ellint2Incomplete; ^this.primitiveFailed }
	// Requires -1 <= k <= 1
	ellipInt2c { _Ellint2Complete; ^this.primitiveFailed }
	// Requires -1 <= k <= 1 and n < 1/sin2(φ)
	ellipInt3i { |n, phi| _Ellint3Incomplete; ^this.primitiveFailed	}
	// Requires -1 <= k <= 1 and n < 1
	ellipInt3c { |n| _Ellint3Complete; ^this.primitiveFailed }
	// Requires -1 <= k <= 1
	ellipIntDi { |phi| _EllintDIncomplete; ^this.primitiveFailed }
	// Requires -1 <= k <= 1
	ellipIntDc { _EllintDComplete; ^this.primitiveFailed }

	// Jacobi Zeta Function
	// Requires -1 <= k <= 1
	zetaJ { |phi| _JacobiZeta; ^this.primitiveFailed }

	// Heuman Lambda Function
	// Requires -1 <= k <= 1
	lambdaH { |phi| _HeumanLambda; ^this.primitiveFailed }


	/*  Jacobi Elliptic F unctions  */
	// k must be positive
	ellipJcd { |u| _JacobiCd; ^this.primitiveFailed }
	ellipJcn { |u| _JacobiCn; ^this.primitiveFailed }
	ellipJcs { |u| _JacobiCs; ^this.primitiveFailed }
	ellipJdc { |u| _JacobiDc; ^this.primitiveFailed }
	ellipJdn { |u| _JacobiDn; ^this.primitiveFailed }
	ellipJds { |u| _JacobiDs; ^this.primitiveFailed }
	ellipJnc { |u| _JacobiNc; ^this.primitiveFailed }
	ellipJnd { |u| _JacobiNd; ^this.primitiveFailed }
	ellipJns { |u| _JacobiNs; ^this.primitiveFailed }
	ellipJsc { |u| _JacobiSc; ^this.primitiveFailed }
	ellipJsd { |u| _JacobiSd; ^this.primitiveFailed }
	ellipJsn { |u| _JacobiSn; ^this.primitiveFailed }

	// Riemann Zeta Function
	zetaR { _Zeta; ^this.primitiveFailed }

	/*  Exponential Integrals */
	expIntEn { |z| _ExpIntEn; ^this.primitiveFailed }
	expInt { _ExpInt; ^this.primitiveFailed }

	/*  Sinus Cardinal ("sinc") and Hyperbolic Sinus Cardinal Functions */
	// sin(x) / x
	sinc { _SinCpi; ^this.primitiveFailed }
	// sinh(x) / x
	sinhc { _SinHCpi; ^this.primitiveFailed }

	/*  Inverse Hyperbolic Functions  */
	asinh { _ASinH; ^this.primitiveFailed }
	// requires x >= 1
	acosh { _ACosH; ^this.primitiveFailed }
	atanh { _ATanH; ^this.primitiveFailed }


	/*  Basic Functions  */
	sinpi { _SinPi; ^this.primitiveFailed }
	cospi { _CosPi; ^this.primitiveFailed }
	log1p { _Log1p; ^this.primitiveFailed }
	expm1{ _ExpM1; ^this.primitiveFailed }
	cbrt { _Cbrt; ^this.primitiveFailed }
	sqrt1pm1 { _Sqrt1pm1; ^this.primitiveFailed }
	powm1{ |y| _PowM1; ^this.primitiveFailed }
	// not needed... slightly slower than current implementation of hypot
	// hypot { _Hypot2; ^this.primitiveFailed }

	/*	Owen's T function */
	owensT { |a| _OwensT; ^this.primitiveFailed }
}
