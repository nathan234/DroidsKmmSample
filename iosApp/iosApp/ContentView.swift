import SwiftUI
import shared

struct ContentView: View {
    let greet = Greeting().greeting()

    @ObservedObject
    var viewModel = ViewModel()

    var body: some View {
        Text(greet)
        Text("Sup Denver Droids")
        Text(viewModel.content)
    }
}

class ViewModel : ObservableObject {
    @Published var content: String  = "loading"

    init() {
        load()
    }

    func load() -> Void {
        Api().about { (text) in
            self.content = text
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}