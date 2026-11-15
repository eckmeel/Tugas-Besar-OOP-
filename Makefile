# Makefile Nangor Blast
# Butuh JDK 21+ (javac & java). Tidak butuh Maven.
#
#   make          compile seluruh kode ke build/classes
#   make run      compile lalu jalankan game
#   make jar      bikin build/NangorBlast.jar
#   make clean    hapus folder build

JAVAC  ?= javac
JAVA   ?= java
JAR    ?= jar
JFLAGS := --release 21 -encoding UTF-8 -Xlint:all,-this-escape

SRC_DIR  := src/main/java
BUILD    := build
OUT      := $(BUILD)/classes
MAIN     := nangorblast.Main
JARFILE  := $(BUILD)/NangorBlast.jar

# wildcard rekursif (portable, tanpa `find`)
rwildcard = $(foreach d,$(wildcard $(1:=/*)),$(call rwildcard,$d,$2) $(filter $(subst *,%,$2),$d))
SOURCES := $(call rwildcard,$(SRC_DIR),*.java)

.PHONY: all build run jar clean

all: build

build: $(SOURCES)
	@mkdir -p $(OUT)
	$(JAVAC) $(JFLAGS) -d $(OUT) $(SOURCES)

run: build
	$(JAVA) -cp $(OUT) $(MAIN)

jar: build
	$(JAR) --create --file $(JARFILE) --main-class $(MAIN) -C $(OUT) .

clean:
	rm -rf $(BUILD)
