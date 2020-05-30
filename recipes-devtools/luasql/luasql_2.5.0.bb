DESCRIPTION = "LuaSQL is a simple interface from Lua to a DBMS."
LICENSE = "MIT"
HOMEPAGE = "https://github.com/keplerproject/luasql"
LIC_FILES_CHKSUM = "file://doc/us/license.html;md5=6eb28d1cec11a3a8ea355a1ebd2fec25"

DEPENDS += "lua-native lua mysql5 sqlite3"

PACKAGES =+ "luasql-mysql luasql-sqlite3"
PROVIDES =+ "luasql-mysql luasql-sqlite3"

RDEPENDS_${PN}-mysql += "libmysqlclient"
RDEPENDS_${PN}-sqlite3 += "libsqlite3"

SRC_URI = "git://github.com/keplerproject/luasql.git;branch=master \
           file://0001-build-patch.patch"

SRCREV = "5496d60185db0c4578e8abe0c74343e99b799311"
S = "${WORKDIR}/git"
LUA_VERSION = "5.3"

inherit autotools pkgconfig

EXTRA_OEMAKE = "LUAV=${LUA_VERSION} LUA_LIBDIR=${D}/${libdir}/lua/${LUA_VERSION} \
                LUA_INC=${RECIPE_SYSROOT}/usr/include LUA_DIR=${D}/${datadir}/lua/${LUA_VERSION} \
                DRIVER_INCS_mysql=-I${RECIPE_SYSROOT}/usr/include/mysql \
                DRIVER_LIBS_mysql='-L${RECIPE_SYSROOT}/usr/lib -lmysqlclient' \
                DRIVER_INCS_sqlite3=-I${RECIPE_SYSROOT}/usr/include/ \
                DRIVER_LIBS_sqlite3='-L${RECIPE_SYSROOT}/usr/lib -lsqlite3' \
"


do_compile() {
    cd ${S}
    oe_runmake mysql
    oe_runmake sqlite3
}

do_install() {
    cd ${S}
    oe_runmake install
}

FILES_${PN}-mysql = "${libdir}/lua/${LUA_VERSION}/luasql/mysql.so"
FILES_${PN}-sqlite3 = "${libdir}/lua/${LUA_VERSION}/luasql/sqlite3.so"
