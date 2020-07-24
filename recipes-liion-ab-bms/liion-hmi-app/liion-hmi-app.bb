SUMMARY = "liion_hmi application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PV = "1.0${PR}"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = 			" \
				file://bms_config.txt \
				file://dkmem \
				file://general_hmi_settings.txt \
				file://golden_ts_cal.txt \
				file://liion_hmi \
				file://liion_hmi_autorun.sh \
				file://liion_hmi_hdmi \
				file://liion_hmi_lcd \
				file://modbus_tcp_ip_server \
				file://network_config.txt \
				file://ts_cal.txt \
				file://wifi_process_manager \
          			"

# avoid QA error by skipping QA test for ldflags
INSANE_SKIP_${PN} = "ldflags"

do_install () {
	install -d ${D}/home/liion
        install -m 0644 ${WORKDIR}/bms_config.txt ${D}/home/liion
        install -m 0644 ${WORKDIR}/dkmem ${D}/home/liion
        install -m 0644 ${WORKDIR}/general_hmi_settings.txt ${D}/home/liion
        install -m 0644 ${WORKDIR}/golden_ts_cal.txt ${D}/home/liion
        install -m 0644 ${WORKDIR}/liion_hmi ${D}/home/liion
        install -m 0644 ${WORKDIR}/liion_hmi_autorun.sh ${D}/home/liion
        install -m 0644 ${WORKDIR}/liion_hmi_hdmi ${D}/home/liion
        install -m 0644 ${WORKDIR}/liion_hmi_lcd ${D}/home/liion
        install -m 0644 ${WORKDIR}/modbus_tcp_ip_server ${D}/home/liion
        install -m 0644 ${WORKDIR}/network_config.txt ${D}/home/liion
        install -m 0644 ${WORKDIR}/ts_cal.txt ${D}/home/liion
        install -m 0644 ${WORKDIR}/wifi_process_manager ${D}/home/liion
}

FILES_${PN} += "/home/liion"


