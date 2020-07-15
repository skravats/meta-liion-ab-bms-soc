PR = "r0"
FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_arrow-sockit += " \
				file://socfpga_cyclone5_ab_bms_soc.dts \
				file://socfpga-4.14-ltsi/cfg/altvipfb.cfg \
				file://socfpga-4.14-ltsi/cfg/block.cfg \
				file://socfpga-4.14-ltsi/cfg/cma.cfg \
				file://socfpga-4.14-ltsi/cfg/configfs.cfg \
				file://socfpga-4.14-ltsi/cfg/gpio-keys.cfg \
				file://socfpga-4.14-ltsi/cfg/led-triggers.cfg \
				file://socfpga-4.14-ltsi/cfg/usb-gadget.cfg \
				"

do_compile_prepend () {                                                            

        cp ${TOPDIR}/../meta-meta-liion-ad-bms-soc/recipes-kernel/linux/config/socfpga_cyclone5_ad_bms_soc.dts ${S}/arch/${ARCH}/boot/dts                          
}  
