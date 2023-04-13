## 開發注意事項

- 每個頁面應該創建自己的資料夾，例如首頁要創建 `home` 的資料夾、登入頁面要創建 `login` 的資料夾，注意名稱是小寫
  - 請對著 `MainActivity` 所在的資料夾`點右鍵 -> New -> Package` 來創建
- 每個資料夾內應該要有三個類別 (Class)：
  - `XXXXConctact`: 連結 View 與 Presenter
    - *必須是 Interface*，且 Interface 底下應該要有 `View` 和 `Presenter` 的 Interface
  - `XXXXActivity`: View，負責處理畫面呈現
  - `XXXXPresenter`: Presenter，負責處理邏輯
  - 以 `home` 為例，相關命名應該為 `HomeContract`、`HomeActivity`、`HomePresenter`
  - **`Activity` 與 `Presenter` 必須 implements `Conctact` 底下的 Interface (重要)**
- `model` 為存放個別頁面的 model 資料夾，底下相關類別名稱應該為 `XXXXRepository` 和 `XXXXApi`，如 `HomeRepository`、`HomeApi`
  - *Repository* 負責撰寫給 Presenter 呼叫的方法 (Method)， *Api* 則是負責資料傳遞
  - 建議假資料寫在 `XXXXApi` 內，往後做資料替換時 (e.g. 換成真實伺服器上的資料) 會更方便