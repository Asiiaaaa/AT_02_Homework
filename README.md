**Задание 1**

Создайте новый проект с шаблоном Gradle в IntelliJ IDEA.
В файле build.gradle добавьте в блок dependencies следующую запись:
implementation group: 'io.appium', name: 'java-client', version: '7.5.1.
Примените новые настройки (нажмите на слоника с синими стрелками).
Слева вы видите иерархию созданного вами проекта. Выберите папку src. Здесь представлены два основных модуля: main и test. В модуле main в папке java создайте класс для настройки Android-драйвера (назовите его, например, DriverFactory), в котором по очереди:
объявите переменную driver типа AndroidDriver;
создайте метод setUp() типа AndroidDriver, используя следующий синтаксис: public void setUp(){};
создайте переменную capabilities типа DesiredCapabilities;
у переменной capabilities вызовите метод setCapability(), в аргументах которого передайте platformName = android: capabilities.setCapability("platformName", "ANDROID");
создайте переменную remoteUrl и сразу же инициализируйте ее с помощью = new URL("http://localhost:4723/wd/hub");
верните объект типа AndroidDriver с помощью записи: return new AndroidDriver(remoteUrl, capabilities);
В модуле test создайте тестовый класс.В этом классе:
объявите переменную driver типа AndroidDriver:
private AndroidDriver driver;
объявите переменную типа класса с настройкой драйвера (например, DriverFactory): private DriverFactory driverFactory;
создайте метод setDriver() типа void, пометьте его аннотацией @Before, как представлено ниже:
@Before
public void setDriver() {
в метод добавьте инициализацию объявленных выше переменных, например:
driverFactory = new DriverFactory();
driver = driverFactory.setUp();
создайте метод test() типа void, пометьте его аннотацией @Test;
создайте метод tearDown() типа void, пометьте его аннотацией @After и добавьте внутрь метода запись: driver.quit();
Запустите Appium в терминале.
Откройте Android-эмулятор.
Откройте на эмуляторе приложение «Настройки» и узнайте его идентификатор и стартовую активность.
Передайте эти данные в capabilities вашего Java-проекта:
capabilities.setCapability(APP_PACKAGE, "какое-то значение");
capabilities.setCapability(APP_ACTIVITY, "какое-то значение");
Закройте приложение «Настройки» на эмуляторе и запустите тест.
Проверьте, что тест запускается без ошибок и на эмуляторе на несколько миллисекунд появляется приложение «Настройки».


Советы и рекомендации
Идентификатор приложения и его стартовую активность можно узнать с помощью команды в терминале:
adb shell dumpsys window displays | grep -E 'mCurrentFocus|mFocusedApp'
Если вы не успеваете посмотреть, что открывающееся приложение — это именно «Настройки», вы можете привести метод test() к виду ниже, и тогда оно будет активно на экране в течение 5 секунд:
public void test() throws InterruptedException
{     Thread.sleep(Long.parseLong("5000")); }


**Задание 2**

В модуле main создайте класс для настройки iOS-драйвера, название придумайте сами.
Скопируйте туда содержимое класса настройки Android-драйвера, заменив везде AndroidDriver на IOSDriver.
Удалите записи, содержащие APP_PACKAGE и APP_ACTIVITY.
В capability platformName поменяйте значение на “ios”.
В модуле test создайте тестовый класс.
Скопируйте туда содержимое тестового класса для Android, заменив AndroidDriver на IOSDriver и класс настройки Android-драйвера на класс настройки iOS-драйвера (например, с DriverFactory на IosDriverFactory).
Выберите любой понравившийся вам симулятор iOS. Узнать список всех симуляторов iOS можно с помощью команды: xcrun xctrace list devices.
Передайте вашему драйверу с помощью capabilities информацию о выбранном симуляторе, например:
capabilities.setCapability(DEVICE_NAME, "iPhone 12 Pro Max");
capabilities.setCapability(PLATFORM_VERSION, "14.4");
capabilities.setCapability(UDID,"6E6ED0AF-003B-400D-B88F-FDDB08A74432");
Найдите идентификатор приложения Messages и вставьте его в capabilities класса настройки iOS-драйвера.
Проверьте, что тест запускается без ошибок и на несколько миллисекунд открывается приложение Messages.


Советы и рекомендации
Информация о симуляторе iOS содержит в себе 3 capabilities:
DEVICE_NAME, PLATFORM_VERSION, UDID.
Идентификатор приложения описывается в capability: BUNDLE_ID.