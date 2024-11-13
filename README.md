[![](https://jitpack.io/v/ngoconglinh/aTextViewGradientStroke.svg)](https://jitpack.io/#ngoconglinh/aTextViewGradientStroke)

## Quick Start

**aTextViewGradientStroke** is available on jitpack.

Add dependency:

```groovy
implementation "com.github.ngoconglinh:aTextViewGradientStroke:1.0.0"
```

## Usage

to use **TextViewGradientStroke**:

in **Setting.gradle**
```groovy
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```
```xml
    <com.ngoconglinh.app.TextViewGradientStroke
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Ngo Cong Linh"
    android:textSize="30sp"
    app:gsIsShowShadow="true"
    app:gsIsShowGradient="true"
    app:gsIsShowStroke="true"
    app:gsShadowColor="#FF0000"
    app:gsShadowDx="10"
    app:gsShadowDy="10"
    app:gsShadowRadius="20"
    app:gsStrokeWidth="15"
    app:strokeOrientation="horizontal"
    app:gsStartStrokeColor="#FFFFFF"
    app:gsEndStrokeColor="#3A3A3A"
    app:gsGradientStartColor="#89FF00"
    app:gsGradientEndColor="#FF3D00"
    app:gradientOrientation="vertical"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```
