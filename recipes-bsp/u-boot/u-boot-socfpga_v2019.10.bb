require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SRC_URI = "git://github.com/altera-opensource/u-boot-socfpga.git;branch=socfpga_v2019.10"
SRCREV = "72bbbc5eeeafe69bcee85f288a112e7cfab3edff"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"

PR = "r0"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append_liion-ab-bms-soc +=	" \
					file://soc_system.rbf \
					file://socfpga_liion_ab_bms_soc_defconfig \
					file://Kconfig \
					file://socfpga_liion_ab_bms_soc.h \
					file://socfpga_common.h \
					file://config_distro_bootcmd.h \
					file://socfpga_cyclone5_liion_ab_bms_soc.dts \
					file://socfpga_cyclone5_sockit.dts \
					file://Makefile \
					file://liion/ab-bms-soc/MAINTAINERS \
					file://liion/ab-bms-soc/Makefile \
					file://liion/ab-bms-soc/socfpga.c \
					file://liion/ab-bms-soc/qts/iocsr_config.h \
					file://liion/ab-bms-soc/qts/pinmux_config.h \
					file://liion/ab-bms-soc/qts/pll_config.h \
					file://liion/ab-bms-soc/qts/sdram_config.h \
           				"

do_compile_prepend () {
        install -m 0644 ${THISDIR}/files/socfpga_liion_ab_bms_soc_defconfig ${S}/configs
        install -m 0644 ${THISDIR}/files/Kconfig ${S}/arch/arm/mach-socfpga/Kconfig
        install -m 0644 ${THISDIR}/files/socfpga_liion_ab_bms_soc.h ${S}/include/configs
        install -m 0644 ${THISDIR}/files/socfpga_common.h ${S}/include/configs
        install -m 0644 ${THISDIR}/files/config_distro_bootcmd.h ${S}/include
        install -m 0644 ${THISDIR}/files/socfpga_cyclone5_liion_ab_bms_soc.dts ${S}/arch/arm/dts
        install -m 0644 ${THISDIR}/files/socfpga_cyclone5_sockit.dts ${S}/arch/arm/dts
        install -m 0644 ${THISDIR}/files/Makefile ${S}/arch/arm/dts
	mkdir -p ${S}/board/liion/ab-bms-soc/qts
        install -m 0644 ${THISDIR}/files/liion/ab-bms-soc/MAINTAINERS ${S}/board/liion/ab-bms-soc
        install -m 0644 ${THISDIR}/files/liion/ab-bms-soc/Makefile ${S}/board/liion/ab-bms-soc
        install -m 0644 ${THISDIR}/files/liion/ab-bms-soc/socfpga.c ${S}/board/liion/ab-bms-soc
        install -m 0644 ${THISDIR}/files/liion/ab-bms-soc/qts/iocsr_config.h ${S}/board/liion/ab-bms-soc/qts
        install -m 0644 ${THISDIR}/files/liion/ab-bms-soc/qts/pinmux_config.h ${S}/board/liion/ab-bms-soc/qts
        install -m 0644 ${THISDIR}/files/liion/ab-bms-soc/qts/pll_config.h ${S}/board/liion/ab-bms-soc/qts
        install -m 0644 ${THISDIR}/files/liion/ab-bms-soc/qts/sdram_config.h ${S}/board/liion/ab-bms-soc/qts
}


