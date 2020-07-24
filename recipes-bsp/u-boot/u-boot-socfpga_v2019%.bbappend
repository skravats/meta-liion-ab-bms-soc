PR = "r0"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_liion-ab-bms-soc += " \
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


do_compile_prepend() {
        install -m 0644 ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/soc_system.rbf ${DEPLOYDIR}
        cp ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/socfpga_liion_ab_bms_soc_defconfig ${S}/configs
        cp ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/Kconfig ${S}/arch/arm/mach-socfpga/Kconfig
        cp ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/socfpga_liion_ab_bms_soc.h ${S}/include/configs
        cp ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/socfpga_common.h ${S}/include/configs
        cp ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/config_distro_bootcmd.h ${S}/include
        cp ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/socfpga_cyclone5_liion_ab_bms_soc.dts ${S}/arch/arm/dts
        cp ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/socfpga_cyclone5_sockit.dts ${S}/arch/arm/dts
        cp ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/Makefile ${S}/arch/arm/dts
	mkdir -p ${S}/board/liion/ab-bms-soc/qts
        cp ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/liion/ab-bms-soc/MAINTAINERS ${S}/board/liion/ab-bms-soc
        cp ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/liion/ab-bms-soc/Makefile ${S}/board/liion/ab-bms-soc
        cp ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/liion/ab-bms-soc/socfpga.c ${S}/board/liion/ab-bms-soc
        cp ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/liion/ab-bms-soc/qts/iocsr_config.h ${S}/board/liion/ab-bms-soc/qts
        cp ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/liion/ab-bms-soc/qts/pinmux_config.h ${S}/board/liion/ab-bms-soc/qts
        cp ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/liion/ab-bms-soc/qts/pll_config.h ${S}/board/liion/ab-bms-soc/qts
        cp ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/liion/ab-bms-soc/qts/sdram_config.h ${S}/board/liion/ab-bms-soc/qts
}

#        install -m 0644 ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/soc_system.rbf ${DEPLOYDIR}/boot
#        install -m 0644 ${TOPDIR}/../meta-liion-ab-bms-soc/recipes-bsp/u-boot/files/soc_system.rbf ${D}/boot


