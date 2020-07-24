SUMMARY = "liion_hmi initialisation service"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SECTION = "liion-ab-bms-soc"

PR = "r1"

inherit systemd

PACKAGE_ARCH = "${MACHINE_ARCH}"
PV = "1.0${PR}"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "file://liion_hmi_autorun.service"

do_install() {
	install -d ${D}${base_libdir}/systemd/system
	install -m -0644 ${WORKDIR}/liion_hmi_autorun.service.service ${D}${base_libdir}/systemd/system
}

ALLOW_EMPTY_${PN} = "1"

FILES_${PN}-network = "${base_libdir}/systemd/system/liion_hmi_autorun.service"


NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "liion_hmi_autorun.service"
DISTRO_FEATURES = "systemd"
